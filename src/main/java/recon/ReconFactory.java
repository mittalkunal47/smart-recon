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
    public static final String BINARY = "608060405234801561001057600080fd5b50610c4b806100206000396000f3006080604052600436106100555763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166295f44e811461005a578063bef7034c146100bf578063dad309a314610100575b600080fd5b34801561006657600080fd5b5061006f610142565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156100ab578181015183820152602001610093565b505050509050019250505060405180910390f35b3480156100cb57600080fd5b506100d76004356101b1565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b34801561010c57600080fd5b5061014060043560243560443560643573ffffffffffffffffffffffffffffffffffffffff60843581169060a435166101e6565b005b606060008054806020026020016040519081016040528092919081815260200182805480156101a757602002820191906000526020600020905b815473ffffffffffffffffffffffffffffffffffffffff16815260019091019060200180831161017c575b5050505050905090565b60008054829081106101bf57fe5b60009182526020909120015473ffffffffffffffffffffffffffffffffffffffff16905081565b6000868686868686336101f76102d0565b9687526020870195909552604080870194909452606086019290925273ffffffffffffffffffffffffffffffffffffffff908116608086015290811660a08501529190911660c0830152519081900360e001906000f08015801561025f573d6000803e3d6000fd5b50600080546001810182559080527f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56301805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff9290921691909117905550505050505050565b60405161093f806102e1833901905600608060405234801561001057600080fd5b5060405160e08061093f83398101604090815281516020830151918301516060840151608085015160a086015160c09096015160018054600160a060020a03928316600160a060020a031991821617909155600495909555600595909555600692909255600755600280549184169183169190911790556003805492909316911617905561089c806100a36000396000f3006080604052600436106100cf5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630dca825e81146100d45780631dab301e146100ee5780633900d166146101555780633b182cd4146101705780633c4dc5bd14610197578063481c6a75146101ac5780634c9ba852146101ea5780637060c4ad146101f557806371dc71801461020a5780638db3ed6014610215578063a025ccb21461022d578063a8c7307114610242578063cdde64e014610257578063dbc72b671461026c575b600080fd5b3480156100e057600080fd5b506100ec600435610281565b005b3480156100fa57600080fd5b5061010660043561036d565b6040518086815260200185815260200184600381111561012257fe5b60ff16815260200183600181111561013657fe5b60ff168152911515602083015250604080519182900301945092505050f35b34801561016157600080fd5b506100ec6004356024356103b4565b34801561017c57600080fd5b506101856104eb565b60408051918252519081900360200190f35b3480156101a357600080fd5b506101856104f1565b3480156101b857600080fd5b506101c16104f7565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b6100ec600435610513565b34801561020157600080fd5b50610185610611565b6100ec600435610617565b34801561022157600080fd5b5061010660043561074e565b34801561023957600080fd5b506101856107fd565b34801561024e57600080fd5b506101c1610803565b34801561026357600080fd5b5061018561081f565b34801561027857600080fd5b506101c1610825565b6000805b60005482101561036857600080548390811061029d57fe5b906000526020600020906003020190508281600001541480156102d7575060006002820154610100900460ff1660018111156102d557fe5b145b15610321576001810154604051339180156108fc02916000818181858888f1935050505015801561030c573d6000803e3d6000fd5b5060028101805460ff1916600317905561035d565b805483148015610348575060016002820154610100900460ff16600181111561034657fe5b145b1561035d5760028101805460ff191660031790555b600190910190610285565b505050565b600080548290811061037b57fe5b600091825260209091206003909102018054600182015460029092015490925060ff808216916101008104821691620100009091041685565b6103bc610841565b60055482116103ca57600080fd5b506040805160a081018252838152602081018381526000928201838152600160608401819052608084018590528454808201808755958052845160039182027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563810191825594517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56486015592517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5659094018054959695879593919260ff199091169190849081111561049857fe5b0217905550606082015160028201805461ff0019166101008360018111156104bc57fe5b02179055506080919091015160029091018054911515620100000262ff00001990921691909117905550505050565b60065481565b60085481565b60015473ffffffffffffffffffffffffffffffffffffffff1681565b6000805b60005482101561036857600080548390811061052f57fe5b90600052602060002090600302019050828160000154141561060657600254600654600183015460405173ffffffffffffffffffffffffffffffffffffffff909316926064919092020480156108fc02916000818181858888f1935050505015801561059f573d6000803e3d6000fd5b50600354600754600183015460405173ffffffffffffffffffffffffffffffffffffffff909316926064919092020480156108fc02916000818181858888f193505050501580156105f4573d6000803e3d6000fd5b506002818101805460ff191690911790555b600190910190610517565b60055481565b61061f610841565b600554341161062d57600080fd5b506040805160a08101825282815234602082019081526000928201838152606083018490526001608084018190528454808201808755958052845160039182027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563810191825594517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56486015592517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5659094018054959695879593919260ff19909116919084908111156106fc57fe5b0217905550606082015160028201805461ff00191661010083600181111561072057fe5b02179055506080919091015160029091018054911515620100000262ff000019909216919091179055505050565b60008080808080805b6000548210156107c657600080548390811061076f57fe5b9060005260206000209060030201905087816000015414156107bb57805460018201546002830154919850965060ff8082169650610100820481169550620100009091041692506107f2565b600190910190610757565b805460018201546002830154919850965060ff8082169650610100820481169550620100009091041692505b505091939590929450565b60045481565b60025473ffffffffffffffffffffffffffffffffffffffff1681565b60075481565b60035473ffffffffffffffffffffffffffffffffffffffff1681565b6040805160a08101825260008082526020820181905290918201908152602001600081526000602090910152905600a165627a7a72305820f5e54b51b371de9c351f64251848ea2eee674e7d1a23e2a675ac91368296feed0029a165627a7a723058205906100cc2193503310442da2ddd1631ebeb1780cdac8a2f42e1204ffef472bf0029";

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
