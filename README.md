# ucsb-cs56-buy-sell-giveaway

# Fall 2018
Description: Users can exchange free items. The two users are givers and getters

- Zain - ghesebull
- Zach - zholoien
- Yinon - yinonrousso
- Rami - ramipinto
- Juan - juangonzalez20
- Derek - derektkbang

---

### To test with mvn
```
mvn clean
mvn compile
mvn test
```

---

### To test with Jacoco
```
mvn clean
mvn compile
mvn test jacoco:report
firefox file://`pwd`/target/site/jacoco/index.html
```

----

### To run locally

### Setting up your database
You need to create a new mlab database and configure. For this you can follow this tutorial: https://ucsb-cs56-pconrad.github.io/topics/mongodb_mlab/

You should pay special attention to Step 3: *Adding a Collection* and *Creating the user and password*. 


Once you have this. You need copy the contents of *localhost.json.SAMPLE* to *localhost.json* and edit the file with the correct information.

*cp localhost.json.SAMPLE localhost.json*

```
{
 "spring.data.mongodb.database":"fill-in-database-name",
 "spring.data.mongodb.host":"fill-in-host",
 "spring.data.mongodb.password":"fill-in-password",
 "spring.data.mongodb.port":"fill-in-port",
 "spring.data.mongodb.username":"fill-in-username"
}
```

### Setting up your Oauth
You need to create a new Oauth application on github and configure. For this you can follow this tutorial: https://github.com/ucsb-cs56-pconrad/spring-boot-github-oauth-demo02#running-on-localhost-with-https

Note: There is no need to do the first part of step 2 since we already have the filename localhost.json. 

Be sure to pay attention to Step 3, and properly set up your Github Oauth verbatim (expect for app-name, make it your apps name)

Once you have done this, be sure to edit the *localhost.json* file to have your infromation. 
```
"github_client_id":"put-it-here",
    "github_client_secret":"put-it-here",
    "http.port":"8081",
    "server.port":"8082",
    "server.ssl.key-password":"password",
    "server.ssl.key-store":"classpath:KeyStore.jks",
    "server.ssl.key-store-type":"JKS",
    "baseUrl":"https://127.0.0.1:8082",
"salt":"fill-this-with-random-characters"
```


### Running the application on localhost

```
mvn clean
mvn compile
. env.sh
mvn spring-boot:run
```
=======

---

### To deploy to heroku

To deploy on heroku, copy the heroku.json.SAMPLE to heroku.json and fill with all of your information, similar to the 2 steps above. Follow this tutorial: https://github.com/ucsb-cs56-pconrad/spring-boot-github-oauth-demo02#running-on-heroku

Be sure to also edit the heroku.json file with your database information in step 4 of the tutorial link.

Be sure to also edit the *pom.xml* file appname (cs56-f18/ucsb-cs56-buy-sell-giveaway) to have your appname

```
mvn clean
mvn compile
./setHerokuEnv.py --app appname
mvn heroku:deploy
```

Website: https://cs56-f18-buy-sell-giveaway.herokuapp.com

Note: admin page is not accesible unless user is admin in group https://github.com/ucsb-buy-sell-members
For testing purposes, I added Wilson to the group, he just needs to accept the link in his email.

