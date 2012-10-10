/*
 * Copyright 2012 SURFnet bv, The Netherlands
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.surfnet.coin.selfservice.service.impl;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.core.io.ClassPathResource;

import nl.surfnet.coin.selfservice.domain.IdentityProvider;
import nl.surfnet.coin.selfservice.domain.License;
import nl.surfnet.coin.selfservice.domain.ServiceProvider;
import nl.surfnet.coin.selfservice.service.LicensingService;

/**
 * LicensingServiceMock.java
 * 
 */
public class LmngServiceMock implements LicensingService {
  private String endpoint;
  private String user;
  private String password;
  private String port;

  private ObjectMapper objectMapper = new ObjectMapper().enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
      .setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

  private List<License> licenses;


  @SuppressWarnings("unchecked")
  public LmngServiceMock() {
    try {
      TypeReference<List<License>> typeReference = new TypeReference<List<License>>() {
      };
      this.licenses = (List<License>) parseJsonData(typeReference, "lmng-json/licenses.json");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see nl.surfnet.coin.selfservice.service.LicensingService#
   * getLicensesForIdentityProvider
   * (nl.surfnet.coin.selfservice.domain.IdentityProvider)
   */
  @Override
  public List<License> getLicensesForIdentityProvider(IdentityProvider identityProvider) {
    return this.licenses;
  }

  /*
   * (non-Javadoc)
   * 
   * @see nl.surfnet.coin.selfservice.service.LicensingService#
   * getLicensesForIdentityProvider
   * (nl.surfnet.coin.selfservice.domain.IdentityProvider, java.util.Date)
   */
  @Override
  public List<License> getLicensesForIdentityProvider(IdentityProvider identityProvider, Date validOn) {
    return this.licenses;
  }

  /*
   * (non-Javadoc)
   * 
   * @see nl.surfnet.coin.selfservice.service.LicensingService#
   * getLicensesForIdentityProviderAndServiceProvider
   * (nl.surfnet.coin.selfservice.domain.IdentityProvider,
   * nl.surfnet.coin.selfservice.domain.ServiceProvider)
   */
  @Override
  public List<License> getLicensesForIdentityProviderAndServiceProvider(IdentityProvider identityProvider, ServiceProvider serviceProvider) {
    return this.licenses;
  }

  /*
   * (non-Javadoc)
   * 
   * @see nl.surfnet.coin.selfservice.service.LicensingService#
   * getLicensesForIdentityProviderAndServiceProvider
   * (nl.surfnet.coin.selfservice.domain.IdentityProvider,
   * nl.surfnet.coin.selfservice.domain.ServiceProvider, java.util.Date)
   */
  @Override
  public List<License> getLicensesForIdentityProviderAndServiceProvider(IdentityProvider identityProvider, ServiceProvider serviceProvider,
      Date validOn) {
    return this.licenses;
  }

  private Object parseJsonData(TypeReference<? extends Object> typeReference, String jsonFile) {
    try {
      return objectMapper.readValue(new ClassPathResource(jsonFile).getInputStream(), typeReference);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  
  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }
  public void setUser(String user) {
    this.user = user;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public void setPort(String port) {
    this.port = port;
  }

}
