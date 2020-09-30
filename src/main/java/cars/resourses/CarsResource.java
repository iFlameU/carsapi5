package cars.resourses;

import cars.models.Car;
import cars.services.CarsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("api")
public class CarsResource {

    @Inject
    private CarsService carsService;

    @GET
    public Response getCars() {
        return Response.ok(carsService.getCars()).build();
    }

    @POST
    public Response addCar(Car car) {
        carsService.addCar(car);
        return Response.ok().build();
    }

    @PUT
    public Response modifyCar(Car car) {
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
