# CustomLintRulePlayground
 
A playground project to learn and implement custom lint rule which help in maintaining a farely large code's correctness, compliance, performance and security.
As I am also learing so for just to kick start of it, I tried to implement two basic detectors 
- LogDetector - If you have custom suited logger implemented and want to prevent android.util.Log class usages in you commit. This detector can cater to this usecase.
- XMLColorCodeDetector - Simillarly more often than not unknowingly one can forget to add color in xml and hardcode it then and there. Warning can we issue using this rule. 

### To check the lint rule


uncomment in `MainFragment` or put the code in any of the source file
`Log.i("Android Log Lint ","Testing")`

- Command to run lint 
`./gradlew app:lintDebug`
 
In the report you will get the entries like
![alt text](https://user-images.githubusercontent.com/59998231/118513352-430b9a80-b751-11eb-9efa-6dd2ed2c616c.png)




