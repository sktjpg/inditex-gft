# Inditex GFT Technical Test

This repository contains a solution for the Inditex GFT technical test. Below are key aspects of the
project.

## API First

API documentation has been generated using OpenAPI and is located in the `openapi` folder. The entry
point is the `main.yaml` file. The documentation has been split into multiple files for improved
reusability and modularity.

## Execution

No environment variables need to be changed to run the project. Default configurations are located
in the `application.properties` file.

## Example Usage

In this section, detailed instructions on how to use the project will be provided, including
examples of requests and responses for different endpoints.

## Postman Integration Testing

Five integration tests have been developed using Postman, as specified in the prompt. To test these
integration tests, follow these steps:

1. Run the service.
2. Import the configuration file from the `integrationtest` folder. The file is
   named `inditex-integration-test.postman_collection.json`.
3. Run the imported tests.

## Unit Testing

Unit tests have been implemented for the most relevant cases of the controller, use case, and
repository. These tests ensure the robustness and reliability of the application.

## Observations

The codebase adheres to the Ports and Adapters architectural pattern, providing a structured
organization. The project is compartmentalized into three directories, each delineating a specific
aspect of the architecture.

Furthermore, on service initiation, administration of the prices table occurs. In the event of its
existence, the table is expunged and then regenerated utilizing the data sourced from the initial
prompt. This process is facilitated through the incorporation of Flyway.

Lombok has been selectively employed to streamline various tasks, such as the creation of getters,
setters, and constructors.

## Contact

For any inquiries, feel free to reach out via [jponton@icekome.com](mailto:jponton@icekome.com).