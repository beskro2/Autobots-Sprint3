package com.revature.planetarium.service.moon;

import com.revature.planetarium.entities.Moon;
import com.revature.planetarium.entities.Planet;
import com.revature.planetarium.exceptions.MoonFail;
import com.revature.planetarium.repository.moon.MoonDao;


import java.util.Base64;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.List;
import java.util.Optional;

import static com.revature.planetarium.utility.JavalinSetup.planetDao;

public class MoonServiceImp<T> implements MoonService<T> {
    
    private MoonDao moonDao;

    public MoonServiceImp(MoonDao moonDao) {
        this.moonDao = moonDao;
    }

    @Override
    public Boolean createMoon(Moon moon) {
        Boolean createMoonSuccess = true;

        if (moon.getMoonName().length() < 1 || moon.getMoonName().length() > 30) {
            throw new MoonFail("Invalid moon name");
        }

        // check for non numerical alphabetical whitespace or - _ characters
        Pattern p = Pattern.compile("[^a-zA-Z0-9 _-]");
        Matcher m = p.matcher(moon.getMoonName());
        if(m.find()){
            System.out.println("not allowed character");
            throw new MoonFail("Invalid moon name");
        }
        //check for already used names
        Optional<Moon> existingMoon = moonDao.readMoon(moon.getMoonName());
        if (existingMoon.isPresent()) {

            throw new MoonFail("Invalid moon name");
        }
        // check planet id exists
        Optional<Planet> existingPlanet = planetDao.readPlanet(moon.getOwnerId());
        if(existingPlanet.isEmpty()){
            throw new MoonFail("Invalid planet ID");
        }
        //checks valid image file types
        if(!isValidImageType(moon.getImageData())){
            throw new MoonFail("Invalid file type");
        }
        System.out.println(moon.getMoonDescription());
        //checks valid discription length
        if(moon.getMoonDescription().length()>300){
            throw new MoonFail("Invalid moon description");
        }

        //finnal catch all
        Optional<Moon> newMoon = moonDao.createMoon(moon);
        if (newMoon.isEmpty()) {
            System.out.println("test");
            throw new MoonFail("Create new Moon Failed");
        }

        return createMoonSuccess;
    }

//method to check image data
 //Method to check if the image is a valid type (PNG, JPEG) and reject GIFs
private boolean isValidImageType(String base64imagedata) {
    try {
        if (base64imagedata == null) {
            System.out.println("No image data provided.");
            return true; // Invalid if no image data
        }

        byte[] imageBytes = Base64.getDecoder().decode(base64imagedata);
        System.out.println("First byte: " + (imageBytes[0] & 0xFF));
        if (imageBytes[0] == (byte) 0xFF && imageBytes[1] == (byte) 0xD8) {
            return true;
        } else if (imageBytes[0] == (byte) 0x89 && imageBytes[1] == (byte) 0x50 && imageBytes[2] == (byte) 0x4E && imageBytes[3] == (byte) 0x47) {
            return true;
        } else if (imageBytes[0] == (byte) 0x47 && imageBytes[1] == (byte) 0x49 && imageBytes[2] == (byte) 0x46) {
            return false;

            } else {
                System.out.println("Insufficient data to determine image type.");
                return false;
            }

    } catch (IllegalArgumentException e) {
        System.out.println("Invalid Base64 string: " + e.getMessage());
        return false;
    }

}

    @Override
    public Moon selectMoon(T idOrName) {
        Optional<Moon> moon;
        if (idOrName instanceof Integer) {
            moon = moonDao.readMoon((Integer) idOrName);
        } else if (idOrName instanceof String) {
            moon = moonDao.readMoon((String) idOrName);
        } else {
            throw new MoonFail("Identifier must be an Integer or String");
        }
        if(moon.isPresent()) {
            return moon.get();
        } else {
            throw new MoonFail("Moon not found");
        }
    }

    @Override
    public List<Moon> selectAllMoons() {
        return moonDao.readAllMoons();
    }

    @Override
    public List<Moon> selectByPlanet(int planetId) {
        return moonDao.readMoonsByPlanet(planetId);
    }

    @Override
    public Moon updateMoon(Moon moon) {
        Optional<Moon> existingMoon = moonDao.readMoon(moon.getMoonId());
        if (existingMoon.isEmpty()) {
            throw new MoonFail("Moon not found, could not update");
        }
        if (moon.getMoonName().length() < 1 || moon.getMoonName().length() > 30) {
            throw new MoonFail("Moon name must be between 1 and 30 characters, could not update");
        }
        Optional<Moon> moonWithSameName = moonDao.readMoon(moon.getMoonName());
        if (moonWithSameName.isPresent() && moonWithSameName.get().getMoonId() != moon.getMoonId()) {
            throw new MoonFail("Moon name must be unique, could not update");
        }
        Optional<Moon> updatedMoon = moonDao.updateMoon(moon);
        if (updatedMoon.isPresent()) {
            return updatedMoon.get();
        } else {
            throw new MoonFail("Moon update failed, please try again");
        }
    }

    @Override
    public Boolean deleteMoon(T idOrName) {
        boolean deleted;
        if (idOrName instanceof Integer) {
            deleted = moonDao.deleteMoon((int) idOrName);
        } else if (idOrName instanceof String) {
            deleted = moonDao.deleteMoon((String) idOrName);
        } else {
            throw new MoonFail("Invalid moon name");
        }
        if (deleted) {
            return deleted;
        } else {
            throw new MoonFail("Invalid moon name");
        }
    }

}
