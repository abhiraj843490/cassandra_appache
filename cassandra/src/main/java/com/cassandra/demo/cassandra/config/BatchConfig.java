//package com.cassandra.demo.cassandra.config;
//
//import com.cassandra.demo.cassandra.model.CsvModel;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.LineMapper;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfig {
//    @Autowired
//    private DataSource dataSource;
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//    @Bean
//    public FlatFileItemReader<CsvModel> reader(){
//        FlatFileItemReader<CsvModel> reader = new FlatFileItemReader<>();
//        reader.setResource(new ClassPathResource("data_balance.csv"));
//        reader.setLineMapper(getLineMapper());
//        reader.setLinesToSkip(1);
//        return reader;
//    }
//
//    private LineMapper<CsvModel> getLineMapper() {
//        DefaultLineMapper<CsvModel>mapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setNames(new String[]{"Period", "Data_value","STATUS","UNITS","MAGNITUDE","Subject","Group"});
//        lineTokenizer.setIncludedFields(new int[]{1,2,3,5,6,7,8});
//
//        BeanWrapperFieldSetMapper<CsvModel>fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        fieldSetMapper.setTargetType(CsvModel.class);
//        mapper.setLineTokenizer(lineTokenizer);
//        mapper.setFieldSetMapper(fieldSetMapper);
//        return mapper;
//    }
//    @Bean
//    public CsvItemProcessor processor(){
//        return new CsvItemProcessor();
//    }
//    public JdbcBatchItemWriter<CsvModel>writer(){
//        JdbcBatchItemWriter<CsvModel> writer = new JdbcBatchItemWriter<>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<CsvModel>());
//        writer.setSql("INSERT INTO csv_model(id, series_reference, period, data_value, status,units,magnitude,subject,group) values(:id, :series_reference, :period, :data_value, :status,:units,:magnitude,:subject,:group)");
//        writer.setDataSource(this.dataSource);
//        return writer;
//    }
//    @Bean
//    public Job importJob(){
//        return this.jobBuilderFactory.get("CSV-IMPORT-JOB")
//                .incrementer(new RunIdIncrementer())
//                .flow(step1())
//                .end().build();
//    }
//    @Bean
//    public Step step1() {
//        return this.stepBuilderFactory.get("step1")
//                .<CsvModel,CsvModel>chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer())
//                .build();
//    }
//
//
//}
