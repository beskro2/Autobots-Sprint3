# Defects Report


User permissions
4. When logged into the homepage as user1, I can see the planets/moons added by all users, not just mine.  This violates security requirement 2.
5. When logged into the homepage as user2, I can only see celestial objects added by user 2.  User1 and User2 have different privileges not stated in the software requirements.
10. When signed in as user1 you can successfully delete a moon created by user 2.

Moon/Planet name validation
1. I could not add the moon 90Champion because it was rejected and there is also no alert saying ‘Invalid moon name’
2. I could not add the planet 90Zeus-12 Aries_5 either but there was an alert saying ‘Invalid planet name’. The current planet name requirements should allow planet names to start with numbers.
7. When submitting duplicate planet names with extra whitespace, the planet is shown on the home page without the whitespace, giving them the appearance of duplicate planet names. This violates planet requirement 3.
8. When attempting to delete “duplicate” planets, if the original planet without any whitespaces is present, the original is deleted. However, if the planet is not present the user is unable to remove the “duplicate” planet(s) even with the correct amount of whitespaces bringing up an “Invalid planet name” alert.
9. To test the repeated planet names validation, make sure both inputs don’t have an image (file type = None)

Unexpected alert issues
3. When trying to register an already existing username/password, the alert does not appear as expected.
11. When creating a new moon with a duplicate name an expected alert says “[I]nvalid moon name” but the alert received was “[i]nvalid moon name”
6. No alerts for when user submits an invalid file type for planet and moon

Image adding issues
12. .Png can’t be added

Repo/Service Testing for planet creation and deletion - Julio
1. In Planet class, no Planet consructor while User and Moon have one
2. In PlanetDaoImp, deletePlanet does not throw any exception when passing in sad path data
3. In PlanetDaoImp, createPlanet method does not accept "90Aries" as a username according to planet requirements this should be a valid name
4. In PlanetServiceImp, deletePlanet method seems to be only checking if there is an instance of a String variable or Integer variable, no checks to see if planet name is in database or not so it will always try to delete a planet whether or not its in the database.
5. In PlanetServiceImp, deletePlanet is returning a string instead of a boolean.
6. In PlanetServiceImp, deletePlanet has wrong exception message "Planet delete failed, please try again", should be "Invalid planet name"
7. When sending a post request to http://localhost:8080/planetarium/planet and passing in planet name of "90Aries" inside the json body the request will fail, according to planet requirements this should be a valid name


