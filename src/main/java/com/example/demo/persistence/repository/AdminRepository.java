package com.example.demo.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.pojo.AdminPojo;
import com.example.demo.domain.repository.IAdminRepository;
import com.example.demo.persistence.entity.Admin;
import com.example.demo.persistence.mapper.IAdminMapper;

@Repository
public class AdminRepository implements IAdminRepository{
	
	private final IAdminMapper iAdminMapper;
	private final IAdminCrudRepository iAdminCrudRepository;
	
	
	public AdminRepository(IAdminMapper iAdminMapper, IAdminCrudRepository iAdminCrudRepository) {
		this.iAdminMapper = iAdminMapper;
		this.iAdminCrudRepository = iAdminCrudRepository;
	}

	@Override
	public List<AdminPojo> getAll() {
		// TODO Auto-generated method stub
		return iAdminMapper.toAdminPojo(iAdminCrudRepository.findAll());
	}

	@Override
	public Optional<AdminPojo> getAdminById(Long id) {
		// TODO Auto-generated method stub
		return iAdminCrudRepository.findById(id).map(ad->iAdminMapper.toAdminPojo(ad));
	}

	@Override
	public Optional<AdminPojo> getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return iAdminCrudRepository.findAdminByEmail(email).map(ema->iAdminMapper.toAdminPojo(ema));
	}

	@Override
	public AdminPojo save(AdminPojo adminPojo) {
		// TODO Auto-generated method stub
		
		Admin admin = iAdminMapper.toAdmin(adminPojo);
		return iAdminMapper.toAdminPojo(iAdminCrudRepository.save(admin));
	}

	@Override
	public void deleteAdmin(Long id) {
		// TODO Auto-generated method stub
		iAdminCrudRepository.deleteById(id);
	}

}
