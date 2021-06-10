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
    public static final String BINARY = "608060405234801561001057600080fd5b50610b37806100206000396000f3006080604052600436106100555763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166295f44e811461005a578063bef7034c146100bf578063dad309a314610100575b600080fd5b34801561006657600080fd5b5061006f610142565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156100ab578181015183820152602001610093565b505050509050019250505060405180910390f35b3480156100cb57600080fd5b506100d76004356101b1565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b34801561010c57600080fd5b5061014060043560243560443560643573ffffffffffffffffffffffffffffffffffffffff60843581169060a435166101e6565b005b606060008054806020026020016040519081016040528092919081815260200182805480156101a757602002820191906000526020600020905b815473ffffffffffffffffffffffffffffffffffffffff16815260019091019060200180831161017c575b5050505050905090565b60008054829081106101bf57fe5b60009182526020909120015473ffffffffffffffffffffffffffffffffffffffff16905081565b6000868686868686336101f76102d0565b9687526020870195909552604080870194909452606086019290925273ffffffffffffffffffffffffffffffffffffffff908116608086015290811660a08501529190911660c0830152519081900360e001906000f08015801561025f573d6000803e3d6000fd5b50600080546001810182559080527f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56301805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff9290921691909117905550505050505050565b60405161082b806102e1833901905600608060405234801561001057600080fd5b5060405160e08061082b83398101604090815281516020830151918301516060840151608085015160a086015160c09096015160018054600160a060020a03928316600160a060020a0319918216179091556004959095556005959095556006929092556007556002805491841691831691909117905560038054929093169116179055610788806100a36000396000f3006080604052600436106100c45763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630dca825e81146100c95780631dab301e146100e35780633900d1661461014a5780633b182cd4146101655780633c4dc5bd1461018c578063481c6a75146101a15780637060c4ad146101df57806371dc7180146101f45780638db3ed60146101ff578063a025ccb214610217578063a8c730711461022c578063cdde64e014610241578063dbc72b6714610256575b600080fd5b3480156100d557600080fd5b506100e160043561026b565b005b3480156100ef57600080fd5b506100fb600435610357565b6040518086815260200185815260200184600381111561011757fe5b60ff16815260200183600181111561012b57fe5b60ff168152911515602083015250604080519182900301945092505050f35b34801561015657600080fd5b506100e160043560243561039e565b34801561017157600080fd5b5061017a6104d5565b60408051918252519081900360200190f35b34801561019857600080fd5b5061017a6104db565b3480156101ad57600080fd5b506101b66104e1565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b3480156101eb57600080fd5b5061017a6104fd565b6100e1600435610503565b34801561020b57600080fd5b506100fb60043561063a565b34801561022357600080fd5b5061017a6106e9565b34801561023857600080fd5b506101b66106ef565b34801561024d57600080fd5b5061017a61070b565b34801561026257600080fd5b506101b6610711565b6000805b60005482101561035257600080548390811061028757fe5b906000526020600020906003020190508281600001541480156102c1575060006002820154610100900460ff1660018111156102bf57fe5b145b1561030b576001810154604051339180156108fc02916000818181858888f193505050501580156102f6573d6000803e3d6000fd5b5060028101805460ff19166003179055610347565b805483148015610332575060016002820154610100900460ff16600181111561033057fe5b145b156103475760028101805460ff191660031790555b60019091019061026f565b505050565b600080548290811061036557fe5b600091825260209091206003909102018054600182015460029092015490925060ff808216916101008104821691620100009091041685565b6103a661072d565b60055482116103b457600080fd5b506040805160a081018252838152602081018381526000928201838152600160608401819052608084018590528454808201808755958052845160039182027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563810191825594517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56486015592517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5659094018054959695879593919260ff199091169190849081111561048257fe5b0217905550606082015160028201805461ff0019166101008360018111156104a657fe5b02179055506080919091015160029091018054911515620100000262ff00001990921691909117905550505050565b60065481565b60085481565b60015473ffffffffffffffffffffffffffffffffffffffff1681565b60055481565b61050b61072d565b600554341161051957600080fd5b506040805160a08101825282815234602082019081526000928201838152606083018490526001608084018190528454808201808755958052845160039182027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563810191825594517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56486015592517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5659094018054959695879593919260ff19909116919084908111156105e857fe5b0217905550606082015160028201805461ff00191661010083600181111561060c57fe5b02179055506080919091015160029091018054911515620100000262ff000019909216919091179055505050565b60008080808080805b6000548210156106b257600080548390811061065b57fe5b9060005260206000209060030201905087816000015414156106a757805460018201546002830154919850965060ff8082169650610100820481169550620100009091041692506106de565b600190910190610643565b805460018201546002830154919850965060ff8082169650610100820481169550620100009091041692505b505091939590929450565b60045481565b60025473ffffffffffffffffffffffffffffffffffffffff1681565b60075481565b60035473ffffffffffffffffffffffffffffffffffffffff1681565b6040805160a08101825260008082526020820181905290918201908152602001600081526000602090910152905600a165627a7a72305820d1c58550896ecae5cd499c45431cbe4f970f960569ad15baf029254eaac59d770029a165627a7a72305820b38760e958ee0ddc0a4f115c3516da57ab3a4710e86b449a8110cda7063a6f8d0029";

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
