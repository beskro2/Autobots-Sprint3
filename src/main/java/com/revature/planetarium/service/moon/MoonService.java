package com.revature.planetarium.service.moon;

import java.util.List;

import com.revature.planetarium.entities.Moon;

public interface MoonService<T> {
    
    Boolean createMoon(Moon moon);
    Moon selectMoon(T idOrName);
    List<Moon> selectAllMoons();
    List<Moon> selectByPlanet(int planetId);
    Moon updateMoon(Moon moon);
    Boolean deleteMoon(T idOrName);

}
