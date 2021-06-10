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

    address public manager;
    address public cHotelOwnerAddress;
    address public cOyoAddress;
    uint public cHotelId;
    uint public cMinBookingAmount;
    uint public cHotelShare;
    uint public cOyoShare;
    uint public bookingAmount;
    modifier restricted() {
        require(msg.sender == manager);
        _;
    }

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

    function bookHotel() public payable {
        require(msg.value > cMinBookingAmount);
        bookingAmount = msg.value;
    }

    function doRecon() public {
        cHotelOwnerAddress.transfer(bookingAmount * cHotelShare / 100);
        cOyoAddress.transfer(bookingAmount * cOyoShare / 100);
    }

}