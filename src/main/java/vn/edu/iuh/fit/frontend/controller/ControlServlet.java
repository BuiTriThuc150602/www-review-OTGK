package vn.edu.iuh.fit.frontend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import vn.edu.iuh.fit.backend.modals.Candidate;
import vn.edu.iuh.fit.backend.modals.Experience;
import vn.edu.iuh.fit.backend.services.CandidateServices;
import vn.edu.iuh.fit.backend.services.ExperienceServices;

@WebServlet(urlPatterns = {"/controller"})
public class ControlServlet extends HttpServlet {

  private final CandidateServices candidateServices = new CandidateServices();
  private final ExperienceServices experienceServices = new ExperienceServices();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String action = req.getParameter("action");
    if (action.equalsIgnoreCase("getAllCandidate")) {
      List<Candidate> candidateList = candidateServices.getAllCandidate();
      req.setAttribute("candidateList", candidateList);
      req.getRequestDispatcher("candidate.jsp").forward(req, resp);
    }
    else if (action.equalsIgnoreCase("viewDetailCandidate")) {
      long can_id = Long.parseLong(req.getParameter("can_id"));
      Candidate candidate = candidateServices.findById(can_id).orElse(null);
      List<Experience> experiences = experienceServices.getExpOfCandidate(can_id);
      req.setAttribute("candidate", candidate);
      req.setAttribute("experiences", experiences);
      req.getRequestDispatcher("candidate_detail.jsp").forward(req, resp);

    } else if (action.equalsIgnoreCase("getCandidateByRole")) {
      String role = req.getParameter("selectRole");
      if (role == null) {
        req.getRequestDispatcher("report1.jsp").forward(req, resp);
      } else {
        System.out.println(role);
        List<Candidate> candidatesByRole = candidateServices.getCandidateByRole(role);
        System.out.println(candidatesByRole);
        req.setAttribute("candidatesByRole", candidatesByRole);
        req.getRequestDispatcher("report1.jsp").forward(req, resp);
      }
    } else if (action.equalsIgnoreCase("getCandidateUseGmail")) {
      List<Candidate> candidatesUseGmail = candidateServices.getCandidateUseGmail();
      req.setAttribute("candidatesUseGmail", candidatesUseGmail);
      req.getRequestDispatcher("report2.jsp").forward(req, resp);
    }

  }
}

