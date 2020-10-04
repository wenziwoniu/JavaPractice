package javaee.spring.test.batch.example01;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

public class BatchTest {

	/**
	 * 功能 : 开发：zwwang 2015-10-14 下午7:40:28
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("spring-batch/jobs.xml");
		Job job = (Job) c.getBean("messageJob");
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository((JobRepository) c.getBean("jobRepository"));
		launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
		try {
			launcher.run(job, new JobParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
