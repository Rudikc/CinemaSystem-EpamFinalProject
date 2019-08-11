package ua.rudikc.cinema.command;

import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.model.Seat;
import ua.rudikc.cinema.service.SeatService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GetSeatsMapCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SeatService seatService = (SeatService) ServiceFactory.getService("seatService");
        int seanceId = Integer.parseInt(request.getParameter("seance_id"));
        ArrayList<ArrayList<Seat>> allSeats = seatService.getListOfRowsOfSeats();
        ArrayList<Seat> busySeats = seatService.getBusySeatsById(seanceId);
        request.setAttribute("all_seats",allSeats);
        request.setAttribute("busy_seats",busySeats);
        return "seats";
    }
}
