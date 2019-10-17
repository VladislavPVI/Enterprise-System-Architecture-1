package com.labs.bean;

import com.labs.domain.Lesson;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class LessonBean {
    @PersistenceContext(unitName = "SchoolMod")
    private EntityManager em;

    public Lesson add(Lesson lesson){
        return em.merge(lesson);
    }

    public Lesson get(Long id){
        return em.find(Lesson.class, id);
    }

    public void update (Lesson lesson){
        add(lesson);
    }

    public void delete(Long id){
        em.remove(get(id));
    }
    public List<Lesson> getAll(){
        TypedQuery<Lesson> namedQuery = em.createNamedQuery("Lesson.getAll",Lesson.class);
        return namedQuery.getResultList();
    }
}
