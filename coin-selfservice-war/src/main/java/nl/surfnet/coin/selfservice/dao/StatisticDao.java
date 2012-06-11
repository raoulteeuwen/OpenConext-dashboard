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

package nl.surfnet.coin.selfservice.dao;

import java.util.List;

import nl.surfnet.coin.selfservice.domain.ChartSerie;
import nl.surfnet.coin.selfservice.domain.StatResult;

/**
 * Service for statistics
 */
public interface StatisticDao {

  /**
   * Makes a List of logins per Service provider for a given Identity provider
   *
   * @param idpEntityId unique identifier of the Identity provider
   * @return List of {@link ChartSerie}
   */
  List<ChartSerie> getLoginsPerSP(String idpEntityId);

  /**
   * Makes a List of login data for all Service Providers for the Identity Provider
   *
   * @param idpEntityId unique identifier of the Identity provider
   * @return List of {@link StatResult}
   */
  List<StatResult> getLoginsPerDay(String idpEntityId);

  /**
   * Makes a List of login data for a specific Service Provider got the Identity Provider
   *
   * @param idpEntityId unique identifier of the Identity provider
   * @param spEntityId  unique identifier of the Service provider
   * @return List of {@link StatResult}
   */
  List<StatResult> getLoginsPerSpPerDay(String idpEntityId, String spEntityId);
}
