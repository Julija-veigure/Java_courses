Feature: Weather API

  Scenario: Testing City coordinates
    Given city id: 524901
    When we are requesting weather data
    Then lon is 145.77
    And lat is -16.92

    And weather is:
      | id          | 802              |
      | main        | Clouds           |
      | description | scattered clouds |
      | icon        | 03n              |

    And base is "stations"

    And data from weather station main:
      | temp        | 300.15 |
      | pressure    | 1007   |
      | humidity    | 74     |
      | temp_min    | 300.15 |
      | temp_max    | 300.15 |


    And visibility is 10000
    And wind speed is 3.6 and deg is 160
    And clouds is 40
    And dt is 1485790200

    And sys:
      | type    | 1          |
      | id      | 8166       |
      | message | 0.2064     |
      | country | AU         |
      | sunrise | 1485720272 |
      | sunset  | 1485766550 |

    And name is "Cairns"
    And cod 200




