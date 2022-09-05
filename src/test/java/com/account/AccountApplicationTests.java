package com.account;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

@SpringBootTest
class AccountApplicationTests {

	@Test
	public void givenAccountDoesNotExists_whenRequestCheckAccount_then406IsReceived() throws IOException {
	
		// Given
		String name = RandomStringUtils.randomAlphabetic( 8 );
		HttpUriRequest request = new HttpGet( "http://localhost:8080/check?account=" + name );

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

		// Then
		assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.SC_NOT_ACCEPTABLE);
	}

}
