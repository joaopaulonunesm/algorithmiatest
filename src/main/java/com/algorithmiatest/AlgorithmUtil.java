package com.algorithmiatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algorithmia.APIException;
import com.algorithmia.AlgorithmException;
import com.algorithmia.Algorithmia;
import com.algorithmia.AlgorithmiaClient;
import com.algorithmia.algo.AlgoResponse;
import com.algorithmia.algo.Algorithm;

public class AlgorithmUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlgorithmUtil.class);

	public AlgorithmiaClient getClient() {
		return Algorithmia.client("simw94XJcZMWMjHz+bjp/pfZxf21");
	}

	public Algorithm getAlgorithmia(AlgorithmiaClient client) {
		Algorithm algo = client.algo("web/WikipediaParser/0.1.2");
		algo.setTimeout(300L, java.util.concurrent.TimeUnit.SECONDS);
		return algo;
	}

	public AlgoResponse getResult(String searchTerm) {

		AlgorithmiaClient client = getClient();
		Algorithm algorithmia = getAlgorithmia(client);

		try {
			return algorithmia.pipe(searchTerm);
		} catch (APIException e) {
			LOGGER.error("APIException", e);
		}
		return null;
	}

	public String getResultString(String searchTerm) {

		AlgorithmiaClient client = getClient();
		Algorithm algorithmia = getAlgorithmia(client);

		try {
			return algorithmia.pipe(searchTerm).asJsonString();
		} catch (APIException e) {
			LOGGER.error("APIException", e);
		} catch (AlgorithmException e) {
			System.out.println(e.getMessage());
			LOGGER.error("AlgorithmException", e);
		}

		return null;
	}

}
