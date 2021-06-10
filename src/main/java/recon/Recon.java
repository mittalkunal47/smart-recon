package recon;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
    public static final String BINARY = "608060405234801561001057600080fd5b5060405160e0806103a783398101604090815281516020830151918301516060840151608085015160a086015160c09096015160008054600160a060020a03928316600160a060020a0319918216179091556003959095556004959095556005929092556006556001805491841691831691909117905560028054929093169116179055610304806100a36000396000f3006080604052600436106100a35763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416633b182cd481146100a85780633c4dc5bd146100cf5780633f14635d146100e4578063481c6a75146100fb5780636f598eb9146101395780637060c4ad14610141578063a025ccb214610156578063a8c730711461016b578063cdde64e014610180578063dbc72b6714610195575b600080fd5b3480156100b457600080fd5b506100bd6101aa565b60408051918252519081900360200190f35b3480156100db57600080fd5b506100bd6101b0565b3480156100f057600080fd5b506100f96101b6565b005b34801561010757600080fd5b5061011061025e565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b6100f961027a565b34801561014d57600080fd5b506100bd61028e565b34801561016257600080fd5b506100bd610294565b34801561017757600080fd5b5061011061029a565b34801561018c57600080fd5b506100bd6102b6565b3480156101a157600080fd5b506101106102bc565b60055481565b60075481565b60015460055460075460405173ffffffffffffffffffffffffffffffffffffffff909316926064919092020480156108fc02916000818181858888f19350505050158015610208573d6000803e3d6000fd5b5060025460065460075460405173ffffffffffffffffffffffffffffffffffffffff909316926064919092020480156108fc02916000818181858888f1935050505015801561025b573d6000803e3d6000fd5b50565b60005473ffffffffffffffffffffffffffffffffffffffff1681565b600454341161028857600080fd5b34600755565b60045481565b60035481565b60015473ffffffffffffffffffffffffffffffffffffffff1681565b60065481565b60025473ffffffffffffffffffffffffffffffffffffffff16815600a165627a7a723058200a9ef333ba3e4861be3f542a9a32bfe9396c8a2a40bcd600cebc3add4af4f8f40029";

    public static final String FUNC_CHOTELSHARE = "cHotelShare";

    public static final String FUNC_BOOKINGAMOUNT = "bookingAmount";

    public static final String FUNC_DORECON = "doRecon";

    public static final String FUNC_MANAGER = "manager";

    public static final String FUNC_BOOKHOTEL = "bookHotel";

    public static final String FUNC_CMINBOOKINGAMOUNT = "cMinBookingAmount";

    public static final String FUNC_CHOTELID = "cHotelId";

    public static final String FUNC_CHOTELOWNERADDRESS = "cHotelOwnerAddress";

    public static final String FUNC_COYOSHARE = "cOyoShare";

    public static final String FUNC_COYOADDRESS = "cOyoAddress";

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

    public RemoteFunctionCall<TransactionReceipt> doRecon() {
        final Function function = new Function(
                FUNC_DORECON, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> manager() {
        final Function function = new Function(FUNC_MANAGER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> bookHotel(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BOOKHOTEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> cMinBookingAmount() {
        final Function function = new Function(FUNC_CMINBOOKINGAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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
