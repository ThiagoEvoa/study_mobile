import 'package:flutter/material.dart';
import 'package:flutter_project/data/model/person_model.dart';
import 'package:flutter_project/data/repository/person_repository.dart';
import 'package:flutter_project/domain/repository/iperson_repository.dart';

class PersonUseCase {
  IPersonRepository _iPersonRepository = PersonRepository();

  retrievePeople() async {
    return _iPersonRepository.retrievePeople();
  }

  savePerson({@required PersonModel personModel}) {
    return _iPersonRepository.savePerson(personModel: personModel);
  }

  updatePerson({@required PersonModel personModel}) {
    return _iPersonRepository.updatePerson(personModel: personModel);
  }

  deletePerson({@required PersonModel personModel}) {
    return _iPersonRepository.deletePerson(personModel: personModel);
  }
}
