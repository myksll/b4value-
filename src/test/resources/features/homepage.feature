Feature: b4value Search


User Story:   As a user, I want to use the search functionality on the b4value website,
              so that I can find relevant information



Scenario: Verify search functionality with a text
  Given I am on the b4value website
  When I  click the Jobs button on the page
  And I click zum b4 Job Portal on Jobs page
  Then I should see  search results related to joboffer

 # When I enter "Software" in the search input
 # And I click the search button
 # Then I should see relevant search results

 #Examples:
   #|text|
   #|Softwaretester|
  #  |Junior        |
  #  |Mitarbeiter   |
