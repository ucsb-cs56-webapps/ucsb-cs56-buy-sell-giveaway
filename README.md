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

### To run locally

Open the localhost.json, freplace the value of spring.data.mongodb.password "REPLACE_WITH_PASSWORD" with the actual password.

```
mvn clean
mvn compile
. env.sh
mvn spring-boot:run
```

---

### To deploy to heroku
```
mvn clean
mvn compile
mvn package heroku:deploy
```
Website: https://cs56-f18-buy-sell-giveaway.herokuapp.com
