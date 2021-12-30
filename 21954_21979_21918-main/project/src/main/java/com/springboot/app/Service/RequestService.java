package com.springboot.app.Service;

import com.springboot.app.Entity.Request;

import java.util.List;

public interface RequestService {
    List<Request> getAllRequests();
    void saveRequest(Request request);
    Request getRequestById(long id);
    void deleteRequestById(long id);
}
