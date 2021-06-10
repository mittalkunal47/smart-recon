pragma solidity ^0.4.17;

contract ReconFactory {
    address[] public deployedReconContracts;

    function createReconContract(uint hotelId, uint minBookingAmount, uint hotelShare, uint oyoShare,
        address hotelOwnerAddress, address oyoAddress) {
        address recon = new Recon(hotelId, minBookingAmount, hotelShare, oyoShare, hotelOwnerAddress,
            oyoAddress, msg.sender);
        deployedReconContracts.push(recon);
    }

    function getDeployedRecons() public view returns (address[]) {
        return deployedReconContracts;
    }

}

contract Recon {

    struct Booking {
        uint bookingId;
        uint bookingValue;
        BookingStatus bookingStatus;
        PaymentStatus paymentStatus;
        bool payNow;
    }
    enum BookingStatus{CONFIRMED, CHECKED_IN, CHECKED_OUT, CANCELLED}
    enum PaymentStatus{PAID, UNPAID}
    Booking[] public bookings;
    address public manager;
    address public cHotelOwnerAddress;
    address public cOyoAddress;
    uint public cHotelId;
    uint public cMinBookingAmount;
    uint public cHotelShare;
    uint public cOyoShare;
    uint public bookingAmount;

    function Recon(uint hotelId, uint minBookingAmount, uint hotelShare, uint oyoShare, address hotelOwnerAddress,
        address oyoAddress, address creator) public {
        manager = creator;
        cHotelId = hotelId;
        cMinBookingAmount = minBookingAmount;
        cHotelShare = hotelShare;
        cOyoShare = oyoShare;
        cHotelOwnerAddress = hotelOwnerAddress;
        cOyoAddress = oyoAddress;
    }

    function payNow(uint nBookingId) public payable {
        require(msg.value > cMinBookingAmount);
        Booking memory newBooking = Booking({
        bookingId : nBookingId,
        bookingValue : msg.value,
        bookingStatus : BookingStatus.CONFIRMED,
        paymentStatus : PaymentStatus.PAID,
        payNow : true
        });
        bookings.push(newBooking);
    }

    function payLater(uint nBookingId, uint amount) public {
        require(amount > cMinBookingAmount);
        Booking memory newBooking = Booking({
        bookingId : nBookingId,
        bookingValue : amount,
        bookingStatus : BookingStatus.CONFIRMED,
        paymentStatus : PaymentStatus.UNPAID,
        payNow : false
        });
        bookings.push(newBooking);
    }

    function getBookingDetails(uint nBookingId) public view returns (uint, uint, BookingStatus, PaymentStatus, bool) {
        for (uint i = 0; i < bookings.length; i++) {
            Booking storage booking = bookings[i];
            if (booking.bookingId == nBookingId) {
                return (
                booking.bookingId,
                booking.bookingValue,
                booking.bookingStatus,
                booking.paymentStatus,
                booking.payNow
                );
            }
        }
        return (
        booking.bookingId,
        booking.bookingValue,
        booking.bookingStatus,
        booking.paymentStatus,
        booking.payNow
        );
    }

    function cancelBooking(uint nBookingId) public {
        for (uint i = 0; i < bookings.length; i++) {
            Booking storage booking = bookings[i];
            if (booking.bookingId == nBookingId && booking.paymentStatus == PaymentStatus.PAID) {
                msg.sender.transfer(booking.bookingValue);
                booking.bookingStatus = BookingStatus.CANCELLED;
            } else if (booking.bookingId == nBookingId && booking.paymentStatus == PaymentStatus.UNPAID) {
                booking.bookingStatus = BookingStatus.CANCELLED;
            }
        }
    }

}