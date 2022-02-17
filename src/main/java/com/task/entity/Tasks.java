package com.task.entity;
 import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Data
@Entity
@Table(name="Tasks")
public class Tasks {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

@Column(name="username", nullable = false)
private String userName;

@Column(name="task")
private String task;

@Column(name="description")
private String description;

@Column(name="enddate")
private Date enddate;

@Column(name="status")
private boolean status;
}
