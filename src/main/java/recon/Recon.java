package recon;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.6.4.
 */
@SuppressWarnings("rawtypes")
public class Recon extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b5060405160e0806200109c8339810180604052620000339190810190620000ae565b60018054600160a060020a0319908116600160a060020a039384161790915560049790975560059590955560069390935560079190915560028054851691841691909117905560038054909316911617905562000168565b600062000099825162000159565b9392505050565b600062000099825162000165565b600080600080600080600060e0888a031215620000ca57600080fd5b6000620000d88a8a620000a0565b9750506020620000eb8a828b01620000a0565b9650506040620000fe8a828b01620000a0565b9550506060620001118a828b01620000a0565b9450506080620001248a828b016200008b565b93505060a0620001378a828b016200008b565b92505060c06200014a8a828b016200008b565b91505092959891949750929550565b600160a060020a031690565b90565b610f2480620001786000396000f3006080604052600436106100f05763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630859919e81146100f55780630dca825e1461010a5780631dab301e1461012a5780633900d166146101645780633b182cd4146101845780633c4dc5bd146101a65780634245f2fe146101bb578063481c6a75146101e15780634c9ba852146102035780637060c4ad1461022357806371dc7180146102385780638db3ed601461024b578063a025ccb21461026b578063a8c7307114610280578063cdde64e014610295578063dbc72b67146102aa578063faa4415b146102bf575b600080fd5b610108610103366004610be2565b6102df565b005b34801561011657600080fd5b50610108610125366004610be2565b61033e565b34801561013657600080fd5b5061014a610145366004610be2565b610430565b60405161015b959493929190610e41565b60405180910390f35b34801561017057600080fd5b5061010861017f366004610c08565b610477565b34801561019057600080fd5b506101996105b3565b60405161015b9190610e33565b3480156101b257600080fd5b506101996105b9565b3480156101c757600080fd5b506101d06105bf565b60405161015b959493929190610dc7565b3480156101ed57600080fd5b506101f66107f7565b60405161015b9190610db3565b34801561020f57600080fd5b5061010861021e366004610be2565b610813565b34801561022f57600080fd5b50610199610911565b610108610246366004610be2565b610917565b34801561025757600080fd5b5061014a610266366004610be2565b610a53565b34801561027757600080fd5b50610199610b02565b34801561028c57600080fd5b506101f6610b08565b3480156102a157600080fd5b50610199610b24565b3480156102b657600080fd5b506101f6610b2a565b3480156102cb57600080fd5b506101086102da366004610be2565b610b46565b6000805b6000548210156103395760008054839081106102fb57fe5b90600052602060002090600302019050828160000154141561032e5760028101805461ff001960ff199091166001171690555b6001909101906102e3565b505050565b6000805b60005482101561033957600080548390811061035a57fe5b9060005260206000209060030201905082816000015414801561039457506000600282810154610100900460ff169081111561039257fe5b145b156103e9576001810154604051339180156108fc02916000818181858888f193505050501580156103c9573d6000803e3d6000fd5b50600281018054600360ff199091161761ff001916610200179055610425565b80548314801561041057506001600282810154610100900460ff169081111561040e57fe5b145b156104255760028101805460ff191660031790555b600190910190610342565b600080548290811061043e57fe5b600091825260209091206003909102018054600182015460029092015490925060ff808216916101008104821691620100009091041685565b61047f610ba0565b600554821161048d57600080fd5b506040805160a081018252838152602081018381526000928201838152600160608401819052608084018590528454808201808755958052845160039182027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563810191825594517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56486015592517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5659094018054959695879593919260ff199091169190849081111561055b57fe5b021790555060608201518160020160016101000a81548160ff0219169083600281111561058457fe5b02179055506080919091015160029091018054911515620100000262ff00001990921691909117905550505050565b60065481565b60085481565b606080606080606080606080606080600080600080549050604051908082528060200260200182016040528015610600578160200160208202803883390190505b50600054604080518281526020808402820101909152919850801561062f578160200160208202803883390190505b50600054604080518281526020808402820101909152919750801561065e578160200160208202803883390190505b50600054604080518281526020808402820101909152919650801561068d578160200160208202803883390190505b5060005460408051828152602080840282010190915291955080156106bc578160200160208202803883390190505b509250600091505b6000548210156107e55760008054839081106106dc57fe5b90600052602060002090600302019050806000015487838151811015156106ff57fe5b602090810290910101526001810154865187908490811061071c57fe5b602090810290910101526002810154855160ff9091169086908490811061073f57fe5b90602001906020020190600381111561075457fe5b9081600381111561076157fe5b815250508060020160019054906101000a900460ff16848381518110151561078557fe5b90602001906020020190600281111561079a57fe5b908160028111156107a757fe5b815250508060020160029054906101000a900460ff1683838151811015156107cb57fe5b9115156020928302909101909101526001909101906106c4565b50949a93995091975095509350915050565b60015473ffffffffffffffffffffffffffffffffffffffff1681565b6000805b60005482101561033957600080548390811061082f57fe5b90600052602060002090600302019050828160000154141561090657600254600654600183015460405173ffffffffffffffffffffffffffffffffffffffff909316926064919092020480156108fc02916000818181858888f1935050505015801561089f573d6000803e3d6000fd5b50600354600754600183015460405173ffffffffffffffffffffffffffffffffffffffff909316926064919092020480156108fc02916000818181858888f193505050501580156108f4573d6000803e3d6000fd5b506002818101805460ff191690911790555b600190910190610817565b60055481565b61091f610ba0565b600554341161092d57600080fd5b506040805160a08101825282815234602082019081526000928201838152606083018490526001608084018190528454808201808755958052845160039182027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563810191825594517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56486015592517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5659094018054959695879593919260ff19909116919084908111156109fc57fe5b021790555060608201518160020160016101000a81548160ff02191690836002811115610a2557fe5b02179055506080919091015160029091018054911515620100000262ff000019909216919091179055505050565b60008080808080805b600054821015610acb576000805483908110610a7457fe5b906000526020600020906003020190508781600001541415610ac057805460018201546002830154919850965060ff808216965061010082048116955062010000909104169250610af7565b600190910190610a5c565b805460018201546002830154919850965060ff8082169650610100820481169550620100009091041692505b505091939590929450565b60045481565b60025473ffffffffffffffffffffffffffffffffffffffff1681565b60075481565b60035473ffffffffffffffffffffffffffffffffffffffff1681565b6000805b600054821015610339576000805483908110610b6257fe5b906000526020600020906003020190508281600001541415610b955760028101805461ff001960ff199091166001171690555b600190910190610b4a565b6040805160a0810182526000808252602082018190529091820190815260200160008152600060209091015290565b6000610bdb8235610ed1565b9392505050565b600060208284031215610bf457600080fd5b6000610c008484610bcf565b949350505050565b60008060408385031215610c1b57600080fd5b6000610c278585610bcf565b9250506020610c3885828601610bcf565b9150509250929050565b610c4b81610e97565b82525050565b6000610c5c82610e93565b808452602084019350610c6e83610e8d565b60005b82811015610c9e57610c84868351610d8f565b610c8d82610e8d565b602096909601959150600101610c71565b5093949350505050565b6000610cb382610e93565b808452602084019350610cc583610e8d565b60005b82811015610c9e57610cdb868351610d98565b610ce482610e8d565b602096909601959150600101610cc8565b6000610d0082610e93565b808452602084019350610d1283610e8d565b60005b82811015610c9e57610d28868351610da1565b610d3182610e8d565b602096909601959150600101610d15565b6000610d4d82610e93565b808452602084019350610d5f83610e8d565b60005b82811015610c9e57610d75868351610daa565b610d7e82610e8d565b602096909601959150600101610d62565b610c4b81610eb0565b610c4b81610ed4565b610c4b81610edf565b610c4b81610ed1565b60208101610dc18284610c42565b92915050565b60a08082528101610dd88188610d42565b90508181036020830152610dec8187610d42565b90508181036040830152610e008186610ca8565b90508181036060830152610e148185610cf5565b90508181036080830152610e288184610c51565b979650505050505050565b60208101610dc18284610daa565b60a08101610e4f8288610daa565b610e5c6020830187610daa565b610e696040830186610d98565b610e766060830185610da1565b610e836080830184610d8f565b9695505050505050565b60200190565b5190565b73ffffffffffffffffffffffffffffffffffffffff1690565b151590565b600060048210610ec157fe5b5090565b600060038210610ec157fe5b90565b6000610dc182610eb5565b6000610dc182610ec55600a265627a7a723058200dae94a07df4aa5637635c08d5adcec897d5b4442f65db6215bf6590dfaf0dd36c6578706572696d656e74616cf50037";

    public static final String FUNC_PAYLATERCHECKIN = "payLaterCheckIn";

    public static final String FUNC_CANCELBOOKING = "cancelBooking";

    public static final String FUNC_BOOKINGS = "bookings";

    public static final String FUNC_PAYLATER = "payLater";

    public static final String FUNC_CHOTELSHARE = "cHotelShare";

    public static final String FUNC_BOOKINGAMOUNT = "bookingAmount";

    public static final String FUNC_GETALLBOOKINGS = "getAllBookings";

    public static final String FUNC_MANAGER = "manager";

    public static final String FUNC_CHECKOUT = "checkout";

    public static final String FUNC_CMINBOOKINGAMOUNT = "cMinBookingAmount";

    public static final String FUNC_PAYNOW = "payNow";

    public static final String FUNC_GETBOOKINGDETAILS = "getBookingDetails";

    public static final String FUNC_CHOTELID = "cHotelId";

    public static final String FUNC_CHOTELOWNERADDRESS = "cHotelOwnerAddress";

    public static final String FUNC_COYOSHARE = "cOyoShare";

    public static final String FUNC_COYOADDRESS = "cOyoAddress";

    public static final String FUNC_PAYNOWCHECKIN = "payNowCheckIn";

    @Deprecated
    protected Recon(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Recon(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Recon(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Recon(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> payLaterCheckIn(BigInteger nBookingId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_PAYLATERCHECKIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(nBookingId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelBooking(BigInteger nBookingId) {
        final Function function = new Function(
                FUNC_CANCELBOOKING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(nBookingId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean>> bookings(BigInteger param0) {
        final Function function = new Function(FUNC_BOOKINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> payLater(BigInteger nBookingId, BigInteger amount) {
        final Function function = new Function(
                FUNC_PAYLATER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(nBookingId), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> cHotelShare() {
        final Function function = new Function(FUNC_CHOTELSHARE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> bookingAmount() {
        final Function function = new Function(FUNC_BOOKINGAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<List<BigInteger>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<Boolean>>> getAllBookings() {
        final Function function = new Function(FUNC_GETALLBOOKINGS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint8>>() {}, new TypeReference<DynamicArray<Uint8>>() {}, new TypeReference<DynamicArray<Bool>>() {}));
        return new RemoteFunctionCall<Tuple5<List<BigInteger>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<Boolean>>>(function,
                new Callable<Tuple5<List<BigInteger>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<Boolean>>>() {
                    @Override
                    public Tuple5<List<BigInteger>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<Boolean>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<List<BigInteger>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<Boolean>>(
                                convertToNative((List<Uint256>) results.get(0).getValue()), 
                                convertToNative((List<Uint256>) results.get(1).getValue()), 
                                convertToNative((List<Uint8>) results.get(2).getValue()), 
                                convertToNative((List<Uint8>) results.get(3).getValue()), 
                                convertToNative((List<Bool>) results.get(4).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<String> manager() {
        final Function function = new Function(FUNC_MANAGER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> checkout(BigInteger nBookingId) {
        final Function function = new Function(
                FUNC_CHECKOUT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(nBookingId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> cMinBookingAmount() {
        final Function function = new Function(FUNC_CMINBOOKINGAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payNow(BigInteger nBookingId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_PAYNOW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(nBookingId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean>> getBookingDetails(BigInteger nBookingId) {
        final Function function = new Function(FUNC_GETBOOKINGDETAILS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(nBookingId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> cHotelId() {
        final Function function = new Function(FUNC_CHOTELID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> cHotelOwnerAddress() {
        final Function function = new Function(FUNC_CHOTELOWNERADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> cOyoShare() {
        final Function function = new Function(FUNC_COYOSHARE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> cOyoAddress() {
        final Function function = new Function(FUNC_COYOADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payNowCheckIn(BigInteger nBookingId) {
        final Function function = new Function(
                FUNC_PAYNOWCHECKIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(nBookingId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Recon load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Recon(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Recon load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Recon(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Recon load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Recon(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Recon load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Recon(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Recon> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger hotelId, BigInteger minBookingAmount, BigInteger hotelShare, BigInteger oyoShare, String hotelOwnerAddress, String oyoAddress, String creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(hotelId), 
                new org.web3j.abi.datatypes.generated.Uint256(minBookingAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(hotelShare), 
                new org.web3j.abi.datatypes.generated.Uint256(oyoShare), 
                new org.web3j.abi.datatypes.Address(160, hotelOwnerAddress), 
                new org.web3j.abi.datatypes.Address(160, oyoAddress), 
                new org.web3j.abi.datatypes.Address(160, creator)));
        return deployRemoteCall(Recon.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Recon> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger hotelId, BigInteger minBookingAmount, BigInteger hotelShare, BigInteger oyoShare, String hotelOwnerAddress, String oyoAddress, String creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(hotelId), 
                new org.web3j.abi.datatypes.generated.Uint256(minBookingAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(hotelShare), 
                new org.web3j.abi.datatypes.generated.Uint256(oyoShare), 
                new org.web3j.abi.datatypes.Address(160, hotelOwnerAddress), 
                new org.web3j.abi.datatypes.Address(160, oyoAddress), 
                new org.web3j.abi.datatypes.Address(160, creator)));
        return deployRemoteCall(Recon.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Recon> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger hotelId, BigInteger minBookingAmount, BigInteger hotelShare, BigInteger oyoShare, String hotelOwnerAddress, String oyoAddress, String creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(hotelId), 
                new org.web3j.abi.datatypes.generated.Uint256(minBookingAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(hotelShare), 
                new org.web3j.abi.datatypes.generated.Uint256(oyoShare), 
                new org.web3j.abi.datatypes.Address(160, hotelOwnerAddress), 
                new org.web3j.abi.datatypes.Address(160, oyoAddress), 
                new org.web3j.abi.datatypes.Address(160, creator)));
        return deployRemoteCall(Recon.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Recon> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger hotelId, BigInteger minBookingAmount, BigInteger hotelShare, BigInteger oyoShare, String hotelOwnerAddress, String oyoAddress, String creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(hotelId), 
                new org.web3j.abi.datatypes.generated.Uint256(minBookingAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(hotelShare), 
                new org.web3j.abi.datatypes.generated.Uint256(oyoShare), 
                new org.web3j.abi.datatypes.Address(160, hotelOwnerAddress), 
                new org.web3j.abi.datatypes.Address(160, oyoAddress), 
                new org.web3j.abi.datatypes.Address(160, creator)));
        return deployRemoteCall(Recon.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
