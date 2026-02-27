package com.DataLogGen.demo.job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DataLogGen.demo.job.Job;
import com.DataLogGen.demo.job.JobRepository;
import com.DataLogGen.demo.job.jobService;

@Service
public class jobServiceimpl implements jobService {
   
    JobRepository jobRepository;

    public jobServiceimpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
     return jobRepository.findAll();
        
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
    if (jobRepository.existsById(id)) {
        jobRepository.deleteById(id);
        return true;
    }
    return false;
   }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if (jobOptional.isPresent()) {
                Job job = jobOptional.get();
                job.setTitle(updateJob.getTitle());
                job.setDescription(updateJob.getDescription());
                job.setMinSalory(updateJob.getMinSalory());
                job.setMaxSalory(updateJob.getMaxSalory());
                job.setLocation(updateJob.getLocation());
                jobRepository.save(job);
                return true;
            }
        return false;
    }
        
}
