package com.impulse.student;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public void addOrUpdate(final Student student) {
    final Consumer<Student> cons = stu -> this.entityManager.merge(stu);
    cons.accept(student);
  }

  public Student getById(final int id) {
    final Function<Integer, Student> func = i -> this.entityManager.find(Student.class, i);
    return func.apply(Integer.valueOf(id));
  }

  public List<Student> findAll() {
    final Supplier<List<Student>> sup = () -> this.entityManager
        .createQuery("SELECT n FROM Student n", Student.class).getResultList();
    return sup.get();

  }

  @Transactional
  public void delete(final Student student) {
    final Consumer<Student> cons = stu -> this.entityManager.remove(stu);
    cons.accept(student);
  }

}
