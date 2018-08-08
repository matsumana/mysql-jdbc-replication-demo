package info.matsumana.demo

import info.matsumana.demo.entity.Todo
import info.matsumana.demo.service.TodoService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java.enclosingClass)
    }

    @Bean
    fun init(service: TodoService) = CommandLineRunner {
        val newTodo = Todo()
        newTodo.title = "title0"
        service.insert(newTodo)

        log.debug("found row from slave  = {}", service.selectFromSlave())

        // TODO SQL error occurs when executed on master
//        log.debug("found row from master = {}", service.selectFromMaster())
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
