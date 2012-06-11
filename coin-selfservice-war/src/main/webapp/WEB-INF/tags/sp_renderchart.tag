<%@ include file="/WEB-INF/jsp/include.jsp" %>
  <%--
  Copyright 2012 SURFnet bv, The Netherlands

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  --%>
<%--@elvariable id="sp" type="nl.surfnet.coin.selfservice.domain.ServiceProvider"--%>
<c:if test="${not empty sp}">
<script src="<c:url value="/js/highstock.js"/>"></script>
  <script src="<c:url value="/js/modules/exporting.js"/>"></script>
  <script>
    $(function () {
      var seriesOptions = [];
      var name, logins, day;

      $.ajax({
        <spring:url value="/loginsperspperday.json" htmlEscape="true" var="jsonUrl">
          <spring:param name="spentityid" value="${sp.id}"/>
        </spring:url>
        url:'${jsonUrl}',
        success:function (result) {
          $.each(result, function (key, val) {
            name = key;
            logins = [];
            for (var i = 0, maxLen = val.length; i < maxLen; i++) {
              day = [val[i].date, val[i].logins];
              logins.push(day);
            }
            seriesOptions.push({
              name:name,
              data:logins
            })

          });

          if (seriesOptions.length > 0) {
            createChart();
            $(chart.renderTo).setAttribute("style", "width:96%;height:400px;");
          }
        },
        cache:false
      });

      // create the chart when all data is loaded
      function createChart() {
        chart = new Highcharts.StockChart({
          chart:{
            renderTo:'chart',
            type:'column'
          },
          colors: [
            '#4FB3CF'
          ],
          global:{
            useUTC: false
          },
          legend:{
            enabled:false,
            layout:"vertical",
            shadow:true
          },
          plotOptions:{
            connectNulls:false
          },
          rangeSelector:{
            selected:4
          },
          series:seriesOptions,
          title:{
            text:"<spring:message code="graph.title.numberoflogins" javaScriptEscape="true" arguments="${selectedidp.name}"/>"
          },
          tooltip:{
            pointFormat:'<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b><br/>',
            valueDecimals:0
          },
          yAxis:{
            min:0,
            plotLines:[
              {
                value:0,
                width:2,
                color:'silver'
              }
            ]
          }

        });
      }
    });
  </script>
</c:if>
