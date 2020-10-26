import 'package:flutter_project/domain/entity/person_entity.dart';

class PersonModel extends PersonEntity {
  PersonModel({String id, String name}) : super(id: id, name: name);

  factory PersonModel.fromJson(Map<String, dynamic> json) {
    return PersonModel(id: json['_id'], name: json['name']);
  }

  Map<String, dynamic> toJson() {
    return {'_id': id, 'name': name};
  }

  static List<PersonModel> convertPersonModelToList(dynamic jsonArray) {
    List<dynamic> people =
        jsonArray.map((value) => PersonModel.fromJson(value)).toList();
    return people.cast<PersonModel>();
  }
}
