package com.bizTrack.customers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class CustomerControllerTests {

  @LocalServerPort
  private int port = 9090;
  TestRestTemplate testRestTemplate;

  @Autowired
  private WebApplicationContext wac;
  private MockMvc mockMvc;

  @Before
  public void setup() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void testGetCustomer() throws Exception {
    this.mockMvc
        .perform(get("/customers/{id}", "1"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("1"));
  }

  @Test
  public void TestConnection(){

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    ResponseEntity<String> response = testRestTemplate.exchange(
        createURLWithPort("/createCustomer"),
        HttpMethod.POST, entity, String.class);
    String expected = "[]";
    assertThat(expected.equals(response.getBody()));
  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }
}
