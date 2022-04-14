Feature: travel insurance plan functionality

  @Search
  Scenario: User is able to select Optimal plus pan for the Travel insurance
    Given open "bta" homepage
    And should select "Ceļojumi" category
    When expand Travel Destination dropdown list
    And select "Izvēlies valstis" from the Travel Destination popup
    And select "Pievienot valsti" button
    And select "Indija" from dropdown list
    Then should see that "Indija" is set as final destination
    And press button "Pielietot"
    When expand Activities dropdown list
    And select "Sports" as activity from the Activity Type popup
    Then should see that "Sports" is set as activity
    When press "Saņemt piedāvājumu"
    Then select "Izvēlēties    " under Optimal+ plan
    And open " Apskati, kas ir apdrošināts" reference
    Then should see that the "Kas ir apdrošināts" popup appeared
    When close this popup and press "Turpināt" button
    Then should see empty input fields
