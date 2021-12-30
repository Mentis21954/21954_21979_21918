package com.springboot.app.Service;

import com.springboot.app.Entity.Request;
import com.springboot.app.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public void saveRequest(Request request) {
        this.requestRepository.save(request);
    }

    @Override
    public Request getRequestById(long id) {
        Optional<Request> optional = requestRepository.findById(id);
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
        this.requestRepository.deleteById(id);
    }
}
