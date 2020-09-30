package cars.controllers;

import cars.models.Car;
import cars.services.CarsService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("cars")
public class CarsController {

    @Inject
    private CarsService carsService;

    @GET
    public Response getCars() {
        return Response.ok(carsService.getCars()).build();
    }

    @GET
    @Path("{id}")
    public Response getCar(@PathParam("id") int id) {
        Car car;
        if ((car = carsService.getCar(id)) != null) {
            return Response.ok(car).build();
        } else {
            return Response.status(404).build();
        }
    }

    @POST
    public Response addCar(@Valid Car car) {
        carsService.addCar(car);
        return Response.ok().build();
    }

    @PUT
    public Response modifyCar(@Valid Car car) {
        carsService.modifyCar(car);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCar(@PathParam("id") int id) {
        carsService.deleteCar(id);
        return Response.ok().build();
    }
}
