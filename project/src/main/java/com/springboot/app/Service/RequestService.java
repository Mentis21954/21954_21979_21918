package com.springboot.app.Service;

import com.springboot.app.Entity.Request;
import com.springboot.app.Repository.RequestRepository;
import com.springboot.app.Repository.RoleRepository;
import com.springboot.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService implements RequestServiceInterface{

    @Autowired
    private RequestRepository repoReq ;


    @Override
    public List<Request> getAllRequests() {
        return repoReq.findAll();
    }

    @Override
    public void saveRequest(Request request) {
        this.repoReq.save(request);
    }

    @Override
    public Request getRequestById(long id) {
        return repoReq.getById(id);
    }

    @Override
    public void deleteRequestById(long id) {
        this.repoReq.deleteById(id);
    }

    public List<Request> getStudentRequests(Long id) {
        List<Request> requestlist =  repoReq.findAll();
        for(int i=0 ; i<requestlist.size(); i++) {
            if(!requestlist.get(i).getReceiver().getId().equals(id)) {
                requestlist.remove(i);
            }
        }
        return requestlist;
    }

    public List<Request> getStudentRequests(String username) {
        List<Request> requestlist =  repoReq.findAll();
        for(int i=0 ; i<requestlist.size(); i++) {
            if(!(requestlist.get(i).getReceiver().getUsername().equals(username))) {
                requestlist.remove(i);
            }
        }
        return requestlist;
    }

    public List<Request> viewUserLetters(Long id) {
        List<Request> requestlist =  repoReq.findAll();
        for(int i=0 ; i<requestlist.size(); i++) {
            if((!requestlist.get(i).getId().equals(id)) || requestlist.get(i).getStatus().equals("pending")) {
                requestlist.remove(i);
            }
        }
        return requestlist;
    }


}
