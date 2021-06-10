pragma solidity ^0.4.21;
pragma experimental ABIEncoderV2;

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
    enum PaymentStatus{PAID, UNPAID, REFUNDED}

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

    function getAllBookings() public view returns (uint[] memory, uint[] memory,
        BookingStatus[] memory, PaymentStatus[] memory, bool[] memory) {
        uint[] memory bookingId = new uint[](bookings.length);
        uint[] memory bookingValue = new uint[](bookings.length);
        BookingStatus[] memory bookingStatus = new BookingStatus[](bookings.length);
        PaymentStatus[] memory paymentStatus = new PaymentStatus[](bookings.length);
        bool[] memory payNow = new bool[](bookings.length);
        for (uint i = 0; i < bookings.length; i++) {
            Booking storage booking = bookings[i];
            bookingId[i] = booking.bookingId;
            bookingValue[i] = booking.bookingValue;
            bookingStatus[i] = booking.bookingStatus;
            paymentStatus[i] = booking.paymentStatus;
            payNow[i] = booking.payNow;
        }
        return (bookingId, bookingValue, bookingStatus, paymentStatus, payNow);
    }

    function cancelBooking(uint nBookingId) public {
        for (uint i = 0; i < bookings.length; i++) {
            Booking storage booking = bookings[i];
            if (booking.bookingId == nBookingId && booking.paymentStatus == PaymentStatus.PAID) {
                msg.sender.transfer(booking.bookingValue);
                booking.bookingStatus = BookingStatus.CANCELLED;
                booking.paymentStatus = PaymentStatus.REFUNDED;
            } else if (booking.bookingId == nBookingId && booking.paymentStatus == PaymentStatus.UNPAID) {
                booking.bookingStatus = BookingStatus.CANCELLED;
            }
        }
    }

    function checkout(uint nBookingId) public {
        for (uint i = 0; i < bookings.length; i++) {
            Booking storage booking = bookings[i];
            if (booking.bookingId == nBookingId) {
                cHotelOwnerAddress.transfer(booking.bookingValue * cHotelShare / 100);
                cOyoAddress.transfer(booking.bookingValue * cOyoShare / 100);
                booking.bookingStatus = BookingStatus.CHECKED_OUT;
            }
        }
    }

    function payNowCheckIn(uint nBookingId) public {
        for (uint i = 0; i < bookings.length; i++) {
            Booking storage booking = bookings[i];
            if (booking.bookingId == nBookingId) {
                booking.bookingStatus = BookingStatus.CHECKED_IN;
                booking.paymentStatus = PaymentStatus.PAID;
            }
        }
    }

    function payLaterCheckIn(uint nBookingId) public payable {
        for (uint i = 0; i < bookings.length; i++) {
            Booking storage booking = bookings[i];
            if (booking.bookingId == nBookingId) {
                booking.bookingStatus = BookingStatus.CHECKED_IN;
                booking.paymentStatus = PaymentStatus.PAID;
            }
        }
    }

}