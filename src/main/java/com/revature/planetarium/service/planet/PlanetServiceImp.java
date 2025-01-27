package com.revature.planetarium.service.planet;

import com.revature.planetarium.entities.Planet;
import com.revature.planetarium.exceptions.PlanetFail;
import com.revature.planetarium.repository.planet.PlanetDao;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlanetServiceImp<T> implements PlanetService<T> {

    private PlanetDao planetDao;

    public PlanetServiceImp(PlanetDao planetDao) {
        this.planetDao = planetDao;
    }

    @Override
    public Planet createPlanet(Planet planet) {
        //System.out.println("This is the image string: " + planet.getImageData());
        //System.out.println("this is the byte array" + planet.imageDataAsByteArray());
        if (planet.getPlanetName().length() < 1 || planet.getPlanetName().length() > 30) {
            throw new PlanetFail("Invalid planet name");
        }
        Pattern pattern = Pattern.compile("[@$#^&*()]");
        Matcher matcher = pattern.matcher(planet.getPlanetName());
        if (matcher.find()) {
            throw new PlanetFail("Invalid planet name");
        }
        Optional<Planet> existingPlanet = planetDao.readPlanet(planet.getPlanetName());
        if (existingPlanet.isPresent()) {
            throw new PlanetFail("Invalid planet name");
        }

        if (!isValidImageType(planet.getImageData())){
            throw new PlanetFail("Invalid file type");
        }
        Optional<Planet> createdPlanet = planetDao.createPlanet(planet);
        if (createdPlanet.isPresent()) {
            return createdPlanet.get();
        } else {
            throw new PlanetFail("Cannot create planet");
        }
    }

    @Override
    public Planet selectPlanet(T idOrName) {
        Optional<Planet> planet;
        if (idOrName instanceof Integer) {
            planet = planetDao.readPlanet((int) idOrName);
        } else if (idOrName instanceof String) {
            planet = planetDao.readPlanet((String) idOrName);
        } else {
            throw new PlanetFail("identifier must be an Integer or String");
        }
        if (planet.isPresent()) {
            return planet.get();
        } else {
            throw new PlanetFail("Planet not found");
        }
    }

    @Override
    public List<Planet> selectAllPlanets() {
        return planetDao.readAllPlanets();
    }

    @Override
    public List<Planet> selectByOwner(int ownerId) {
        return planetDao.readPlanetsByOwner(ownerId);
    }

    @Override
    public Planet updatePlanet(Planet planet) {
        Optional<Planet> existingPlanet = planetDao.readPlanet(planet.getPlanetId());
        if (existingPlanet.isEmpty()) {
            throw new PlanetFail("Planet not found, could not update");
        }
        if (planet.getPlanetName().length() < 1 || planet.getPlanetName().length() > 30) {
            throw new PlanetFail("Planet name must be between 1 and 30 characters, could not update");
        }
        if (!planet.getPlanetName().equals(existingPlanet.get().getPlanetName())) {
            if (planetDao.readPlanet(planet.getPlanetName()).isPresent()) {
                throw new PlanetFail("Planet name must be unique, could not update");
            }
        }
        Optional<Planet> updatedPlanet = planetDao.updatePlanet(planet);
        if (updatedPlanet.isPresent()) {
            return updatedPlanet.get();
        } else {
            throw new PlanetFail("Planet update failed, please try again");
        }
    }

    @Override
    public boolean deletePlanet(T idOrName) {
        boolean deleted;
        if (idOrName instanceof Integer) {
            deleted = planetDao.deletePlanet((int) idOrName);
        } else if (idOrName instanceof String) {
            deleted = planetDao.deletePlanet((String) idOrName);
        } else {
            throw new PlanetFail("identifier must be an Integer or String");
        }
        if (deleted) {
            return true;
        } else {
            throw new PlanetFail("Invalid planet name");
        }
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

}
