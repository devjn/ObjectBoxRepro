package com.example.common;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class BoxObject {
    @Id
    public long id;
}
