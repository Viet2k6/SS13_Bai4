package org.example.ss13_bai4.repository;

import org.example.ss13_bai4.model.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MedicineRepository {

    @Autowired
    private SessionFactory sessionFactory;
    public List<Medicine> findExpiredMedicines() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Medicine m WHERE m.expiryDate < :currentDate";
        return session.createQuery(hql, Medicine.class)
                .setParameter("currentDate", LocalDate.now())
                .getResultList();
    }
}