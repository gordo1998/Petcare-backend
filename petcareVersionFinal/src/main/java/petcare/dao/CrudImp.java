package petcare.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import petcare.entities.Cuenta;
import petcare.entities.Reserva;
import petcare.entities.Serviciocuidador;

public class CrudImp<T, E, ID> implements CrudJpaRepository<E, ID>{



	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends E> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends E> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<E> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<ID> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E getOne(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getReferenceById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends E> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends E> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends E> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> findAllById(Iterable<ID> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends E> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<E> findById(ID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(ID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(E entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends ID> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends E> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<E> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<E> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends E> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends E> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends E> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends E> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends E, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeByName(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cuenta retrieveCuenta(String correo, String contraseña) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta retrieveCuenta(String correo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> pruebilla() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> retrieveReservas(int idDueño) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serviciocuidador> getServicioCuidador(int servicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEntidad(E entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEntidad(E entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEntidad(int idEntidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<E> getEntidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E retrieveEntidades(int idEntidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E retrieveEntidades(E entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E retrieveEntidades(String correo, String contraseña) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E retrieveEntidades(String correo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCuenta(E entidad) {
		// TODO Auto-generated method stub
		
	}

}
