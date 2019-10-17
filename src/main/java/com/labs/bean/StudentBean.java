package com.labs.bean;

import com.labs.domain.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class StudentBean {

    @PersistenceContext(unitName = "SchoolMod")
    private EntityManager em;

    public void add(Student student){
        em.merge(student);
    }

    public Student get(Long id){
        return em.find(Student.class, id);
    }

    public void update (Student student){
        add(student);
    }

    public void delete(Long id){
        em.remove(get(id));
    }
    public List<Student> getAll(){
        TypedQuery<Student> namedQuery = em.createNamedQuery("Student.getAll",Student.class);
        return namedQuery.getResultList();
    }
}
