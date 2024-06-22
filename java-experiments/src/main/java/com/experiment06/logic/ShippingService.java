package com.experiment06.logic;

import com.experiment06.logic.ShippingService;
import com.experiment06.entity.*;

public class ShippingService {
    public static Ship loadContainers(Ship ship, Container[] containers) throws OverweightException {
        for (Container container : containers) {
            ship.loadContainer(container);
        }
        return ship;
    }
}