Meta:

Narrative:
As a user
I want to be able to create sign in in Gmail accout
and send message to me , after that i want to opend my sended message

Scenario: Send message verificatino
Given I am on www.mail.google.com
When I login into gmail account with valid credentials shheanaid15@gmail.com annacarenina768232
And I click 'write' button so then message popup should be open and i could fill in all needed fields to send
created mail  with shheanaid15@gmail.com Test Example_Test_Message data
And I find sent message  by sender я and open it
Then I verify correctness of sent message by subject Test
