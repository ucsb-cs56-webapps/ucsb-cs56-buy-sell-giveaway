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
firefox file://'pwd'/target/site/jacoco/index.html
```

----

### To run locally
```
mvn clean
mvn compile
mvn spring-boot:run
```
=======

---

### To deploy to heroku
```
mvn clean
mvn compile
mvn package heroku:deploy
```
Website: https://cs56-f18-buy-sell-giveaway.herokuapp.com
