package com.example.trydapp;

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
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class KingOfCountry extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060405161019f38038061019f8339818101604052602081101561003357600080fd5b505060018055610157806100486000396000f3fe6080604052600436106100345760003560e01c8063747c8dd214610039578063a035b1fe14610043578063cc181ca81461006a575b600080fd5b61004161009b565b005b34801561004f57600080fd5b5061005861010d565b60408051918252519081900360200190f35b34801561007657600080fd5b5061007f610113565b604080516001600160a01b039092168252519081900360200190f35b600034116100a857600080fd5b60015434116100b657600080fd5b600080546001546040516001600160a01b039092169281156108fc029290818181858888f193505050501580156100f1573d6000803e3d6000fd5b50600080546001600160a01b0319163317905560023402600155565b60015481565b6000546001600160a01b03168156fea265627a7a72315820e38b1e64e6adbae8acec1fc1b337f247fba8c448b1dc6c17ced1a2566e328bcd64736f6c634300050d0032";

    public static final String FUNC_BECOMEKING = "becomeking";

    public static final String FUNC_KING = "king";

    public static final String FUNC_PRICE = "price";

    @Deprecated
    protected KingOfCountry(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected KingOfCountry(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected KingOfCountry(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected KingOfCountry(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> becomeking(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BECOMEKING, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> king() {
        final Function function = new Function(FUNC_KING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> price() {
        final Function function = new Function(FUNC_PRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static KingOfCountry load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new KingOfCountry(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static KingOfCountry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new KingOfCountry(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static KingOfCountry load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new KingOfCountry(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static KingOfCountry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new KingOfCountry(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<KingOfCountry> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(KingOfCountry.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<KingOfCountry> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(KingOfCountry.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<KingOfCountry> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(KingOfCountry.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<KingOfCountry> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(KingOfCountry.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
