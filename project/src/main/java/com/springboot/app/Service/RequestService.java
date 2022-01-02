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
        Optional<Request> optional = repoReq.findById(id);
        Request request = null;
        if (optional.isPresent()) {
            request = optional.get();
        } else {
            throw new RuntimeException(" Request not found for id :: " + id);
        }
        return request;
    }

    @Override
    public void deleteRequestById(long id) {
        this.repoReq.deleteById(id);
    }


}
