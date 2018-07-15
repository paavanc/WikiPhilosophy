# WikiPhilosophy

Running Locally:

Pre-req: Java8 and Maven3

#### Installation for mac:

1. Install HomeBrew:
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

2. Install Java:

  	1. ```brew tap caskroom/versions```
  
  	2. ```brew cask install java8```
  
3. Install Maven: 

	```brew install maven```
	
4. Run the project:

	In the terminal, run the following command in the WikiPhilosophy directory.

	```mvn spring-boot:run```

	The service should be running on port:9080.

5. Run tests: ```mvn package```

   * This command will run the tests and package the project into a jar.

   * If one cds into WikiPhilosophy/target, one can also run the jar to start the service.

     ```-java -jar hop-0.0.1-SNAPSHOT.jar```

#### Sample POST:

```
curl -X POST \
   http://localhost:9080/wiki \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: fc38bb37-21b6-cedf-8ffd-75836d547676' \
  -d '{
	"url" : "https://en.wikipedia.org/wiki/One_Piece"
}'
```

#### Sample Response:
```
{
    "url": "https://en.wikipedia.org/wiki/One_Piece",
    "hops": [
        "https://en.wikipedia.org/wiki/Manga",
        "https://en.wikipedia.org/wiki/Comics",
        "https://en.wikipedia.org/wiki/Media_(communication)",
        "https://en.wikipedia.org/wiki/Communication",
        "https://en.wikipedia.org/wiki/Meaning_(semiotics)",
        "https://en.wikipedia.org/wiki/Semiotics",
        "https://en.wikipedia.org/wiki/Meaning-making",
        "https://en.wikipedia.org/wiki/Psychology",
        "https://en.wikipedia.org/wiki/Science",
        "https://en.wikipedia.org/wiki/Knowledge",
        "https://en.wikipedia.org/wiki/Fact",
        "https://en.wikipedia.org/wiki/Reality",
        "https://en.wikipedia.org/wiki/Object_of_the_mind",
        "https://en.wikipedia.org/wiki/Mathematical",
        "https://en.wikipedia.org/wiki/Quantity",
        "https://en.wikipedia.org/wiki/Counting",
        "https://en.wikipedia.org/wiki/Element_(mathematics)",
        "https://en.wikipedia.org/wiki/Mathematics",
        "https://en.wikipedia.org/wiki/Mathematical_structure",
        "https://en.wikipedia.org/wiki/Set_(mathematics)",
        "https://en.wikipedia.org/wiki/Object_(mathematics)",
        "https://en.wikipedia.org/wiki/Abstract_object",
        "https://en.wikipedia.org/wiki/Referent",
        "https://en.wikipedia.org/wiki/Name",
        "https://en.wikipedia.org/wiki/Term_(language)",
        "https://en.wikipedia.org/wiki/Word",
        "https://en.wikipedia.org/wiki/Linguistics",
        "https://en.wikipedia.org/wiki/Language",
        "https://en.wikipedia.org/wiki/Human",
        "https://en.wikipedia.org/wiki/Extinct",
        "https://en.wikipedia.org/wiki/Biology",
        "https://en.wikipedia.org/wiki/Natural_science",
        "https://en.wikipedia.org/wiki/Branches_of_science",
        "https://en.wikipedia.org/wiki/Empirical",
        "https://en.wikipedia.org/wiki/Information",
        "https://en.wikipedia.org/wiki/Question",
        "https://en.wikipedia.org/wiki/Referring_expression",
        "https://en.wikipedia.org/wiki/Technical_terminology",
        "https://en.wikipedia.org/wiki/Ingroups_and_outgroups",
        "https://en.wikipedia.org/wiki/Sociology",
        "https://en.wikipedia.org/wiki/Society",
        "https://en.wikipedia.org/wiki/Social_group",
        "https://en.wikipedia.org/wiki/Social_science",
        "https://en.wikipedia.org/wiki/Discipline_(academia)",
        "https://en.wikipedia.org/wiki/Branch_(academia)",
        "https://en.wikipedia.org/wiki/Education",
        "https://en.wikipedia.org/wiki/Learning",
        "https://en.wikipedia.org/wiki/Behavior",
        "https://en.wikipedia.org/wiki/American_English",
        "https://en.wikipedia.org/wiki/English_language",
        "https://en.wikipedia.org/wiki/West_Germanic_language",
        "https://en.wikipedia.org/wiki/Germanic_languages",
        "https://en.wikipedia.org/wiki/Indo-European_languages",
        "https://en.wikipedia.org/wiki/Asia",
        "https://en.wikipedia.org/wiki/Earth",
        "https://en.wikipedia.org/wiki/Planet",
        "https://en.wikipedia.org/wiki/Astronomical_body",
        "https://en.wikipedia.org/wiki/Physical_body",
        "https://en.wikipedia.org/wiki/Physics",
        "https://en.wikipedia.org/wiki/Matter",
        "https://en.wikipedia.org/wiki/Classical_physics",
        "https://en.wikipedia.org/wiki/Paradigm_shift",
        "https://en.wikipedia.org/wiki/Thomas_Kuhn",
        "https://en.wikipedia.org/wiki/History_of_science",
        "https://en.wikipedia.org/wiki/History_of_scholarship",
        "https://en.wikipedia.org/wiki/Fields_of_study",
        "https://en.wikipedia.org/wiki/Research",
        "https://en.wikipedia.org/wiki/Theorem",
        "https://en.wikipedia.org/wiki/Statement_(logic)",
        "https://en.wikipedia.org/wiki/Logic",
        "https://en.wikipedia.org/wiki/Truth",
        "https://en.wikipedia.org/wiki/Modernity",
        "https://en.wikipedia.org/wiki/Modern_era",
        "https://en.wikipedia.org/wiki/Historiography",
        "https://en.wikipedia.org/wiki/Historian",
        "https://en.wikipedia.org/wiki/Recorded_history",
        "https://en.wikipedia.org/wiki/History",
        "https://en.wikipedia.org/wiki/Prehistory",
        "https://en.wikipedia.org/wiki/Stone_tools",
        "https://en.wikipedia.org/wiki/Paleolithic",
        "https://en.wikipedia.org/wiki/Stone_tool",
        "https://en.wikipedia.org/wiki/Epipaleolithic",
        "https://en.wikipedia.org/wiki/Upper_Paleolithic",
        "https://en.wikipedia.org/wiki/Stone_Age",
        "https://en.wikipedia.org/wiki/Mesolithic",
        "https://en.wikipedia.org/wiki/Neolithic",
        "https://en.wikipedia.org/wiki/Neolithic_Revolution",
        "https://en.wikipedia.org/wiki/Human_culture",
        "https://en.wikipedia.org/wiki/Social_behavior",
        "https://en.wikipedia.org/wiki/Organism",
        "https://en.wikipedia.org/wiki/Entity",
        "https://en.wikipedia.org/wiki/Existence",
        "https://en.wikipedia.org/wiki/Universe",
        "https://en.wikipedia.org/wiki/Space",
        "https://en.wikipedia.org/wiki/Linear",
        "https://en.wikipedia.org/wiki/Line_(geometry)",
        "https://en.wikipedia.org/wiki/Curvature",
        "https://en.wikipedia.org/wiki/Surface_(topology)",
        "https://en.wikipedia.org/wiki/Topology",
        "https://en.wikipedia.org/wiki/Continuous_function",
        "https://en.wikipedia.org/wiki/Function_(mathematics)",
        "https://en.wikipedia.org/wiki/History_of_the_function_concept",
        "https://en.wikipedia.org/wiki/Calculus",
        "https://en.wikipedia.org/wiki/Abacus",
        "https://en.wikipedia.org/wiki/Hindu%E2%80%93Arabic_numeral_system",
        "https://en.wikipedia.org/wiki/Positional_notation",
        "https://en.wikipedia.org/wiki/Number",
        "https://en.wikipedia.org/wiki/Mathematical_object",
        "https://en.wikipedia.org/wiki/Philosophy_of_mathematics",
        "https://en.wikipedia.org/wiki/Philosophy"
    ]
}
```

#### Server:

The restful service is hosted on this url: https://powerful-tundra-37904.herokuapp.com. 
Note that since this url is hosted on a free Heroku service there may be some intial latency when one first hits the API.

#### Sample POST:

```
curl -X POST \
  https://powerful-tundra-37904.herokuapp.com/wiki \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: fc38bb37-21b6-cedf-8ffd-75836d547676' \
  -d '{
	"url" : "https://en.wikipedia.org/wiki/One_Piece"
}'
```

#### Performance:

The time complexity to find the number of hops per a url is unfortunately O(n^2) at its worst, O(n) otherwise. When clicking the first
link on every wiki page, I discovered certian links would lead to circular loops.  In order to counter this problem, I implemented a set, so that we could keep track and skip links we had already visited in the past when scanning a wiki page.

Note, when a succesful API call is made we recieve a 200 Http status code, because we are not always inserting a record in the database, if one already exists.

Currently we are running one instance of the app in Heroku. The app relies on an internal memory key value store (Concurrent HashMap). 
The look up time for finding a url and its hops is O(1), once the url and its paths are stored in the key value database. The url acts as they key in the hash and the hops as the value. 
However, there are pitfalls with this approach. One of them is that the in memory database goes down (clears out) everytime the service goes down or is put to sleep by Heroku.

If I was building this app to scale, I would probably set up a Redis Database and allocate more nodes to the service.  
I would also increase the number of replicas on each on node depending on the traffic. An elastic load balancer would handle the distribution between replicas with multiple calls. Tools such as Kubernetes and AWS can be used
 to help with this type of scaling. 

#### Important Files:

* /src/main/java/wiki/link/hop - controllers, managers, repositories
* /src/main/java/wiki/link/hop/manager/impl/WikiPathManagerImpl.java - main logic
* /src/test/java/wiki/link/hop/HopApplicationTests.java - integration tests
