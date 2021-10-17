@Smoke
Feature: SEB user has to have a ability to calculate Makse rate

  Scenario Outline: User is getting correct rate for <LeaseType>
    Given As a SEB user I open Lease Calculator page and close the Cookies popup
    When input "10000" value and "10" value
    And select "<LeaseType>" lease type
    Then correct rate "<expectedRate>" is displayed
    Examples:
      | LeaseType | expectedRate |
      | KAS       | 122,84       |
      | KAP       | 125,79       |
      | JM        | 125,79       |


  Scenario: User is getting comparison table for KAS
    Given As a SEB user I open Lease Calculator page and close the Cookies popup
    When input "10000" value and "10" value
    And select "KAS" lease type
    And click on Lisa Vordlusesse button
    Then leasing type "KAS" in comparison table is displayed

