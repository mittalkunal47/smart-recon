package recon;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class ReconFactory extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506106b3806100206000396000f3006080604052600436106100555763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166295f44e811461005a578063bef7034c146100bf578063dad309a314610100575b600080fd5b34801561006657600080fd5b5061006f610142565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156100ab578181015183820152602001610093565b505050509050019250505060405180910390f35b3480156100cb57600080fd5b506100d76004356101b1565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b34801561010c57600080fd5b5061014060043560243560443560643573ffffffffffffffffffffffffffffffffffffffff60843581169060a435166101e6565b005b606060008054806020026020016040519081016040528092919081815260200182805480156101a757602002820191906000526020600020905b815473ffffffffffffffffffffffffffffffffffffffff16815260019091019060200180831161017c575b5050505050905090565b60008054829081106101bf57fe5b60009182526020909120015473ffffffffffffffffffffffffffffffffffffffff16905081565b6000868686868686336101f76102d0565b9687526020870195909552604080870194909452606086019290925273ffffffffffffffffffffffffffffffffffffffff908116608086015290811660a08501529190911660c0830152519081900360e001906000f08015801561025f573d6000803e3d6000fd5b50600080546001810182559080527f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56301805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff9290921691909117905550505050505050565b6040516103a7806102e1833901905600608060405234801561001057600080fd5b5060405160e0806103a783398101604090815281516020830151918301516060840151608085015160a086015160c09096015160008054600160a060020a03928316600160a060020a0319918216179091556003959095556004959095556005929092556006556001805491841691831691909117905560028054929093169116179055610304806100a36000396000f3006080604052600436106100a35763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416633b182cd481146100a85780633c4dc5bd146100cf5780633f14635d146100e4578063481c6a75146100fb5780636f598eb9146101395780637060c4ad14610141578063a025ccb214610156578063a8c730711461016b578063cdde64e014610180578063dbc72b6714610195575b600080fd5b3480156100b457600080fd5b506100bd6101aa565b60408051918252519081900360200190f35b3480156100db57600080fd5b506100bd6101b0565b3480156100f057600080fd5b506100f96101b6565b005b34801561010757600080fd5b5061011061025e565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b6100f961027a565b34801561014d57600080fd5b506100bd61028e565b34801561016257600080fd5b506100bd610294565b34801561017757600080fd5b5061011061029a565b34801561018c57600080fd5b506100bd6102b6565b3480156101a157600080fd5b506101106102bc565b60055481565b60075481565b60015460055460075460405173ffffffffffffffffffffffffffffffffffffffff909316926064919092020480156108fc02916000818181858888f19350505050158015610208573d6000803e3d6000fd5b5060025460065460075460405173ffffffffffffffffffffffffffffffffffffffff909316926064919092020480156108fc02916000818181858888f1935050505015801561025b573d6000803e3d6000fd5b50565b60005473ffffffffffffffffffffffffffffffffffffffff1681565b600454341161028857600080fd5b34600755565b60045481565b60035481565b60015473ffffffffffffffffffffffffffffffffffffffff1681565b60065481565b60025473ffffffffffffffffffffffffffffffffffffffff16815600a165627a7a723058200a9ef333ba3e4861be3f542a9a32bfe9396c8a2a40bcd600cebc3add4af4f8f40029a165627a7a723058208f224f19436879e5cfa616aad19264b0a1a45bfca39b96c0cbcf24250ca999db0029";

    public static final String FUNC_GETDEPLOYEDRECONS = "getDeployedRecons";

    public static final String FUNC_DEPLOYEDRECONCONTRACTS = "deployedReconContracts";

    public static final String FUNC_CREATERECONCONTRACT = "createReconContract";

    @Deprecated
    protected ReconFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ReconFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ReconFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ReconFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<List> getDeployedRecons() {
        final Function function = new Function(FUNC_GETDEPLOYEDRECONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<String> deployedReconContracts(BigInteger param0) {
        final Function function = new Function(FUNC_DEPLOYEDRECONCONTRACTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> createReconContract(BigInteger hotelId, BigInteger minBookingAmount, BigInteger hotelShare, BigInteger oyoShare, String hotelOwnerAddress, String oyoAddress) {
        final Function function = new Function(
                FUNC_CREATERECONCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(hotelId), 
                new org.web3j.abi.datatypes.generated.Uint256(minBookingAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(hotelShare), 
                new org.web3j.abi.datatypes.generated.Uint256(oyoShare), 
                new org.web3j.abi.datatypes.Address(160, hotelOwnerAddress), 
                new org.web3j.abi.datatypes.Address(160, oyoAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ReconFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReconFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ReconFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReconFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ReconFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ReconFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ReconFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ReconFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ReconFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReconFactory.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReconFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReconFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ReconFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReconFactory.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReconFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReconFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
