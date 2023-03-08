Feature: Mobile Programming UI Task

Background:
Given user is on chromeBrowser
Given user is on reactjs page

@Test1
Scenario: Reactjs DocsTab validation
When user is clicks on docs tab
And user expand main concept

And user write all main concept data into file
And user expand Advanced guide
And user write all Advanced guide data into file
And user close browser

@Test2
Scenario: Reactjs Tutorial validation
When user is clicks on tutorial tab
Then user verify scroll down function

